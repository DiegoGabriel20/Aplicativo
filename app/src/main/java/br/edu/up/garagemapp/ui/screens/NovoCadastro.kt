@file:Suppress("NAME_SHADOWING")

package br.edu.up.garagemapp.ui.screens

import GaragemViewModel
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.garagemapp.data.lembrar.GaragemInfo
import br.edu.up.garagemapp.ui.screens.visualbar.TopBar
import kotlinx.coroutines.launch

@Composable
fun NovoCadastro(
    reminderId: Int? = null,
    viewModel: GaragemViewModel,
    navController: NavController,
    drawerState: DrawerState
) {
    val coroutineScope = rememberCoroutineScope()

    // Estados dos campos
    var marca by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var ano by remember { mutableStateOf("") }
    var tipoVeiculo by remember { mutableStateOf("Carro") } // Valor padrão é "Carro"
    var imagemUri by remember { mutableStateOf<Uri?>(null) }
    var errorMessage by remember { mutableStateOf("") }

    val label = if (reminderId == null) "Adicionar Veículo" else "Editar Veículo"

    // Launcher para selecionar imagem
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imagemUri = uri
    }

    Scaffold(
        topBar = { TopBar(navController = navController, showBackButton = true) },

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color(0xFF67BDDF))
                    .padding(16.dp)
            ) {
                Text(
                    text = label,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = marca,
                    onValueChange = { marca = it },
                    label = { Text("Marca") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = modelo,
                    onValueChange = { modelo = it },
                    label = { Text("Modelo") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = ano,
                    onValueChange = { ano = it },
                    label = { Text("Ano") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Seleção do tipo de veículo
                Text("Tipo de Veículo", fontWeight = FontWeight.Bold, color = Color.White)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row {
                        RadioButton(
                            selected = tipoVeiculo == "Carro",
                            onClick = { tipoVeiculo = "Carro" }
                        )
                        Text("Carro", color = Color.White)
                    }

                    Row {
                        RadioButton(
                            selected = tipoVeiculo == "Moto",
                            onClick = { tipoVeiculo = "Moto" }
                        )
                        Text("Moto", color = Color.White)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Seleção da imagem
                Button(
                    onClick = { launcher.launch("image/*") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text(
                        text = if (imagemUri == null) "Selecionar Imagem" else "Imagem Selecionada",
                        fontSize = 16.sp,
                        color = Color.Blue
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                if (errorMessage.isNotEmpty()) {
                    Text(
                        text = errorMessage,
                        color = Color.Red,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                Button(
                    onClick = {
                        coroutineScope.launch {
                            if (marca.isEmpty() || modelo.isEmpty() || ano.isEmpty() || imagemUri == null) {
                                errorMessage = "Todos os campos precisam ser preenchidos!"
                            } else {
                                // Criar o objeto GaragemInfo
                                val garagemInfo = GaragemInfo(
                                    id = reminderId,
                                    marca = marca,
                                    modelo = modelo,
                                    ano = ano,
                                    tipo = tipoVeiculo,
                                    imagem = imagemUri.toString()
                                )

                                // Adicionar ao ViewModel
                                viewModel.add(garagemInfo)

                                // Navegar para a tela correta
                                when (tipoVeiculo) {
                                    "Carro" -> navController.navigate("carro screen") {
                                        popUpTo("add screen") { inclusive = true }
                                    }
                                    "Moto" -> navController.navigate("moto screen") {
                                        popUpTo("add screen") { inclusive = true }
                                    }
                                }
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text(text = "Cadastrar", fontSize = 20.sp, color = Color.Blue)
                }
            }
        }
    )
}