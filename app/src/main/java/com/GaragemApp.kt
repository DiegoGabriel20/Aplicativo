package com

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.edu.up.Garagem.ui.screens.Carro.TelaBarco
import br.edu.up.Garagem.ui.screens.Carro.TelaCarro
import br.edu.up.Garagem.ui.screens.Carro.TelaMoto
import com.example.garagemapp.R
import com.example.garagemapp.ui.screens.util.TelaAdicionar
import com.example.garagemapp.ui.screens.util.Textos

object GaragemRotas {
    const val TELA_CARRO_ROTA = "tela_carro"
    const val TELA_MOTO_ROTA = "tela_moto"
    const val TELA_BARCO_ROTA = "tela_barco"
    const val TELA_ADICIONAR_ROTA = "tela_adicionar" // Nova rota para a ação
}

@Preview
@Composable
fun Garagem() {
    val navController = rememberNavController()
    var showDialog by remember { mutableStateOf(true) } // Inicializa como true

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar(navController) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(GaragemRotas.TELA_ADICIONAR_ROTA) },
                containerColor = Color(0xFF4D1AB1),
                contentColor = Color.White
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Floating action button.")
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = GaragemRotas.TELA_CARRO_ROTA,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(GaragemRotas.TELA_CARRO_ROTA) { TelaCarro() }
            composable(GaragemRotas.TELA_MOTO_ROTA) { TelaMoto() }
            composable(GaragemRotas.TELA_BARCO_ROTA) { TelaBarco() }
            composable(GaragemRotas.TELA_ADICIONAR_ROTA) { TelaAdicionar(navController) }
        }
    }

    if (showDialog) {
        AlertDialogExample(
            onDismissRequest = { showDialog = false },
            onConfirmation = {
                // Ação de confirmação, se necessário
                showDialog = false
            },
            dialogTitle = "Bem-Vindo a GaragemApp",
            dialogText = "Esse é um aplicativo que permite você gerenciar seus veículos, comece tocando no botão com o +",
            icon = Icons.Filled.Add
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        title = {
            Textos.TextShadow(
                text = "Minha Garagem",
                shadowColor = Color.DarkGray,
                offsetX = 18f,
                offsetY = 13f,
                blurRadius = 18f
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF0C8CD4),
            titleContentColor = Color.Yellow
        )
    )
}

@Composable
fun BottomBar(navController: NavController) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = Color(0xFF0C8CD4)
    ) {
        NavigationBarItem(
            selected = currentRoute == GaragemRotas.TELA_CARRO_ROTA,
            onClick = {
                navController.navigate(GaragemRotas.TELA_CARRO_ROTA) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.carroicon),
                    contentDescription = "Ícone de Carro",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = {
                Text(
                    text = "Carros",
                    fontSize = 16.sp,
                    color = if (currentRoute == GaragemRotas.TELA_CARRO_ROTA) Color.Yellow else Color.White
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.Yellow,
                unselectedTextColor = Color.White
            )
        )

        NavigationBarItem(
            selected = currentRoute == GaragemRotas.TELA_MOTO_ROTA,
            onClick = {
                navController.navigate(GaragemRotas.TELA_MOTO_ROTA) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.motoicon),
                    contentDescription = "Ícone de Moto",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = {
                Text(
                    text = "Motos",
                    fontSize = 16.sp,
                    color = if (currentRoute == GaragemRotas.TELA_MOTO_ROTA) Color.Yellow else Color.White
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.Yellow,
                unselectedTextColor = Color.White
            )
        )

        NavigationBarItem(
            selected = currentRoute == GaragemRotas.TELA_BARCO_ROTA,
            onClick = {
                navController.navigate(GaragemRotas.TELA_BARCO_ROTA) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.barcoicon2),
                    contentDescription = "Ícone de Barco",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = {
                Text(
                    text = "Barcos",
                    fontSize = 16.sp,
                    color = if (currentRoute == GaragemRotas.TELA_BARCO_ROTA) Color.Yellow else Color.White
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.Yellow,
                unselectedTextColor = Color.White
            )
        )
    }
}

@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
    AlertDialog(

        title = {
            Text(
                text = dialogTitle,
                fontSize = 28.sp // Aumente o tamanho da fonte aqui
            )
        },
        text = {
            Text(
                text = dialogText,
                fontSize = 22.sp // Aumente o tamanho da fonte aqui
            )
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }

            ) {
                Text("Confirmar")

            }
        },

    )
}
