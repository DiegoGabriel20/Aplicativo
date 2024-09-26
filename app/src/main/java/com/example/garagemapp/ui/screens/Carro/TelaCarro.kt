package br.edu.up.Garagem.ui.screens.Carro

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.Garagem.ui.screens.util.PlannerTopBar
import br.edu.up.Garagem.ui.screens.util.TelaUmBottomBar
import com.example.garagemapp.R

@Composable
fun TelaCarro(
    drawerState: DrawerState,
    navCtrlBottomNav: NavController
) {
    Scaffold(
        topBar = {
            PlannerTopBar(drawerState)
        },
        content = { iPad ->
            iPad
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                Text(
                    text = "Meus Carros",
                    modifier = Modifier.padding(top = 40.dp),
                    fontSize = 60.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A778A)
                )


                Image(
                    painter = painterResource(id = R.drawable.carro2),
                    contentDescription = "Imagem de um carro",
                    modifier = Modifier
                        .size(250.dp)
                        .padding(top = 20.dp, bottom = 16.dp)
                )


                Text(
                    text = "Toyota Supra",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
            }
        },
        bottomBar = { TelaUmBottomBar(navCtrlBottomNav) }
    )
}
