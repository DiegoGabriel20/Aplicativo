package br.edu.up.Garagem.ui.screens.Barco

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.up.Garagem.ui.screens.util.PlannerTopBar
import com.example.garagemapp.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TelaBarco(drawerState: DrawerState) {
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
                    text = "Tela de Barcos", // Alterado para um título mais descritivo
                    fontSize = 40.sp
                )
            }

            Image(
                painter = painterResource(id = R.drawable.barco2),
                contentDescription = "Imagem de um Barco",
                modifier = Modifier.padding(30.dp)

            )
        }
    )
}

