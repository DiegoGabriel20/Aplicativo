package com.example.garagemapp.ui.screens.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaAdicionar(navController: NavController) {
    var vehicleName by remember { mutableStateOf(TextFieldValue()) }
    var vehicleType by remember { mutableStateOf(TextFieldValue()) }
    var vehicleYear by remember { mutableStateOf(TextFieldValue()) }
    val imageUrl by remember { mutableStateOf<String?>(null) }  // Placeholder para URL da imagem

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Adicionar Veículo") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Campo para imagem
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                        .clickable {
                            // Aqui você pode abrir um seletor de imagem (Intent ou outro método)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (imageUrl == null) {
                        Text("Selecionar Imagem", color = Color.White)
                    } else {
                        Image(
                            painter = rememberAsyncImagePainter(imageUrl),
                            contentDescription = "Imagem do Veículo",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(150.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = vehicleName,
                    onValueChange = { vehicleName = it },
                    label = { Text("Nome do Veículo") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = vehicleType,
                    onValueChange = { vehicleType = it },
                    label = { Text("Tipo do Veículo") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = vehicleYear,
                    onValueChange = { vehicleYear = it },
                    label = { Text("Ano do Veículo") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = vehicleType,
                    onValueChange = { vehicleType = it },
                    label = { Text("Kilometragem Rodada") },
                    modifier = Modifier.fillMaxWidth()

                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        // Lógica para salvar os dados, incluindo a URL da imagem
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                ) {
                    Text("Cadastrar", color = Color.White, fontSize = 18.sp)
                }
            }
        }
    )
}
