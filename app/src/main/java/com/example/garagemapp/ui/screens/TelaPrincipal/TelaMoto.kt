package br.edu.up.Garagem.ui.screens.Carro

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.garagemapp.R


@Composable
fun TelaMoto() {
    Scaffold(
        topBar = {
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "Minhas Motos",
                    modifier = Modifier.padding(top = 40.dp),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A778A)
                )

                Image(
                    painter = painterResource(id = R.drawable.moto2),
                    contentDescription = "Imagem de um moto",
                    modifier = Modifier
                        .size(250.dp)
                        .padding(top = 20.dp, bottom = 16.dp)
                )

                Text(
                    text = "Kawasaki Ninja",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                // Exemplo de navegação ao clicar em um botão
                // Adicione seu botão aqui, se necessário
                /* Button(onClick = {
                    navController.navigate("outra_tela")
                }) {
                    Text(text = "Ir para outra tela")
                } */
            }
        }
    )
}
