package br.edu.up.garagemapp.ui.screens.visualbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.garagemapp.ui.theme.OffWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController, showBackButton: Boolean) {

    rememberCoroutineScope()

    TopAppBar(
        title = {
            Text(
                text = "GaragemApp",
                fontSize = 30.sp,
                color = OffWhite,
                fontWeight = FontWeight.Light
            )
        },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = OffWhite // Cor da setinha de voltar
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF0F75DC) // Azul claro
        )
    )
}