package br.edu.up.garagemapp.ui

import GaragemViewModel
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.garagemapp.ui.screens.NovoCadastro
import br.edu.up.garagemapp.ui.screens.Moto
import br.edu.up.garagemapp.ui.screens.Carro

object PlantUpRoutes {
    val SCREEN_VEICULO_ROUTE = "carro screen"
    val SCREEN_CADASTRO_ROUTE = "add screen"
    val SCREEN_MOTO_ROUTE = "moto screen"

}

@Composable
fun Navegar(viewModel: GaragemViewModel) {

    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
        },
        drawerState = drawerState,
        content = {
            NavHost(
                navController = navController,
                startDestination = PlantUpRoutes.SCREEN_VEICULO_ROUTE
            ) {
                composable(PlantUpRoutes.SCREEN_VEICULO_ROUTE) {
                    Carro (drawerState, viewModel, navController)
                }

                composable("editReminder/{reminderId}") { navRequest ->
                    val reminderId = navRequest.arguments?.getString("reminderId")
                    NovoCadastro(reminderId?.toInt(), viewModel, navController, drawerState)
                }
                composable(PlantUpRoutes.SCREEN_CADASTRO_ROUTE) {
                    NovoCadastro(drawerState = drawerState, viewModel = viewModel, navController = navController)
                }
                composable(PlantUpRoutes.SCREEN_MOTO_ROUTE) {
                    Moto (drawerState, viewModel, navController)
                }
            }
        }
    )
}