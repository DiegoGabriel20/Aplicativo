package br.edu.up.Garagem.ui.screens.Carro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.Garagem.ui.screens.util.PlannerTopBar
import br.edu.up.Garagem.ui.screens.util.TelaUmBottomBar

@Composable
fun TelaRotina(
    drawerState: DrawerState,
    navCtrlBottomNav: NavController
) {
    Scaffold(
        topBar = { PlannerTopBar(drawerState) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Tela de Carros", // Altere conforme necessário
                    fontSize = 40.sp
                )
            }
        },
        bottomBar = { TelaUmBottomBar(navCtrlBottomNav) }
    )
}
