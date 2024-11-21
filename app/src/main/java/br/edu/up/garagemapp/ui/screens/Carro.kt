package br.edu.up.garagemapp.ui.screens

import GaragemViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.garagemapp.R
import br.edu.up.garagemapp.ui.PlantUpRoutes
import br.edu.up.garagemapp.ui.screens.visualbar.BottomBar
import br.edu.up.garagemapp.ui.screens.visualbar.TopBar
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.launch

@Composable
fun Carro(
    drawerState: DrawerState,
    viewModel: GaragemViewModel,
    navController: NavController,
) {
    val coroutineScope = rememberCoroutineScope()
    // Filtrando os lembretes para exibir apenas os de tipo "Carro"
    val carros by viewModel.carros.collectAsState()

    Scaffold(
        topBar = { TopBar(navController = navController, showBackButton = false) },
        bottomBar = { BottomBar(navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF67BDDF)) // Cor de fundo azul clara
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Meus Carros",
                    fontSize = 30.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Lista de veículos cadastrados
                for (reminder in carros) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .background(Color(0xFFB0E0E6)) // Cor azul clara para os cards
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Imagem do veículo
                            val vehicleImage = reminder.imagem // Supondo que "imagem" seja a URL da imagem no banco de dados
                            Image(
                                painter = rememberAsyncImagePainter(vehicleImage), // Carrega a imagem com Coil
                                contentDescription = "Imagem do veículo",
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(end = 16.dp),
                                contentScale = ContentScale.Crop
                            )

                            // Informações do veículo
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = reminder.marca,
                                    fontSize = 35.sp,
                                    color = Color.Black,
                                    maxLines = 1
                                )
                                Text(
                                    text = reminder.modelo,
                                    fontSize = 26.sp,
                                    color = Color.Black,
                                    maxLines = 1
                                )

                                Text(
                                    text = "Ano: ${reminder.ano}",
                                    fontSize = 20.sp,
                                    color = Color.DarkGray
                                )
                            }

                            // Botões de ação (Editar e Excluir)
                            Column(
                                horizontalAlignment = Alignment.End
                            ) {
                                IconButton(onClick = {
                                    navController.navigate("editReminder/${reminder.id}")
                                }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.lapis), // Ícone de lápis
                                        contentDescription = "Editar",
                                        tint = Color.Blue
                                    )
                                }

                                IconButton(onClick = {
                                    coroutineScope.launch {
                                        viewModel.remove(reminder)
                                    }
                                }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.lixeira), // Ícone de lixeira
                                        contentDescription = "Excluir",
                                        tint = Color.Red // Cor vermelha para excluir
                                    )
                                }
                            }
                        }
                    }
                }

                Box(modifier = Modifier.fillMaxSize()) {
                    // O conteúdo principal da tela aqui
                    SmallFloatingActionButton(
                        onClick = {
                            navController.navigate(PlantUpRoutes.SCREEN_CADASTRO_ROUTE)
                        },
                        modifier = Modifier
                            .align(Alignment.BottomEnd) // Alinha no canto inferior direito
                            .padding(16.dp) // Ajuste o espaçamento para o botão flutuante
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.adcionar), // Ícone de "+" para adicionar
                            contentDescription = "Adicionar",
                            modifier = Modifier.size(60.dp), // Ajuste o tamanho do ícone
                            tint = Color.Unspecified
                        )
                    }
                }
            }
        }
    )
}
