package br.edu.up.garagemapp.ui.screens.visualbar

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.edu.up.garagemapp.R
import br.edu.up.garagemapp.ui.PlantUpRoutes
import br.edu.up.garagemapp.ui.theme.OffWhite

@Composable
fun BottomBar(navController: NavController) {

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    NavigationBar(containerColor = Color(0xFF0F75DC)) {

        NavigationBarItem(
            selected = currentRoute == PlantUpRoutes.SCREEN_VEICULO_ROUTE,
            onClick = {
                navController.navigate(PlantUpRoutes.SCREEN_VEICULO_ROUTE)
            },
            label = { Text("Carros", color = OffWhite) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.carroicon),
                    modifier = iconSize,
                    contentDescription = "Carros"
                )
            }
        )

        NavigationBarItem(
            selected = currentRoute == PlantUpRoutes.SCREEN_CADASTRO_ROUTE,
            onClick = {
                navController.navigate(PlantUpRoutes.SCREEN_CADASTRO_ROUTE)
            },
            label = { Text("Cadastrar", color = OffWhite) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Create,
                    modifier = iconSize,
                    contentDescription = "Cadastro"
                )
            }
        )

        NavigationBarItem(
            selected = currentRoute == PlantUpRoutes.SCREEN_MOTO_ROUTE,
            onClick = {
                navController.navigate(PlantUpRoutes.SCREEN_MOTO_ROUTE)
            },
            label = { Text("Motos", color = OffWhite) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.moto),
                    modifier = iconSize,
                    contentDescription = "Moto"
                )
            }
        )
    }
}

val iconSize = Modifier.size(30.dp)
