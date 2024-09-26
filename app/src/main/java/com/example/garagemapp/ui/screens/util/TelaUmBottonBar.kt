package br.edu.up.Garagem.ui.screens.util

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.edu.up.Garagem.ui.screens.Carro.TelaUm


import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun TelaUmBottomBar(navController: NavController) {


    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    NavigationBar(containerColor = Color(0xFF1A778A)) {
        NavigationBarItem(
            selected = currentRoute == TelaUm.TELA_AFAZERES_ROUTE,
            onClick = {
                if (currentRoute != TelaUm.TELA_AFAZERES_ROUTE) {
                    navController.navigate(TelaUm.TELA_AFAZERES_ROUTE)
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "A",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = { Text(text = "CARRO", color = Color.White)
                }
        )
        NavigationBarItem(
            selected = currentRoute == TelaUm.TELA_ROTINA_ROUTE,
            onClick = {
                if (currentRoute != TelaUm.TELA_ROTINA_ROUTE) {
                    navController.navigate(TelaUm.TELA_ROTINA_ROUTE)
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "B",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = { Text(text = "MOTO", color = Color.White)
               }

        )
        NavigationBarItem(
            selected = currentRoute == TelaUm.TELA_NOTAS_ROUTE,
            onClick = {
                if (currentRoute != TelaUm.TELA_NOTAS_ROUTE) {
                    navController.navigate(TelaUm.TELA_NOTAS_ROUTE)
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "C",
                    modifier = Modifier.size(40.dp)

                )
            },
            label = { Text(text = "BARCO", color = Color.White)
                }
        )
    }
}
