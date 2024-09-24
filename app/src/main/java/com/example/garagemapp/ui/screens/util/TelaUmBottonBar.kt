package br.edu.up.Garagem.ui.screens.util

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
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


@Composable
fun TelaUmBottomBar(navController: NavController) {
    NavigationBar(containerColor = Color(0xFF98D2FF)) {
        NavigationBarItem(
            selected = true,
            onClick = {
                navController.navigate(TelaUm.TELA_AFAZERES_ROUTE)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "A",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = { Text(text = "CARRO") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(TelaUm.TELA_ROTINA_ROUTE)
            }, icon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "B",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = { Text(text = "MOTO") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(TelaUm.TELA_NOTAS_ROUTE)
            }, icon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "C",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = { Text(text = "BARCO") }
        )
    }
}