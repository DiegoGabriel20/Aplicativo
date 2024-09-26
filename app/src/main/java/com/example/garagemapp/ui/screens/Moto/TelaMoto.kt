import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.up.Garagem.ui.screens.util.PlannerTopBar

import com.example.garagemapp.R

@Composable
fun TelaMoto(drawerState: DrawerState) {
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
                // Texto existente
                Text(
                    text = "Tela de Motos", // Texto mais descritivo
                    fontSize = 40.sp
                )


                Image(
                    painter = painterResource(id = R.drawable.moto1),
                    contentDescription = "Imagem de uma moto",
                    modifier = Modifier.padding(30.dp)

                )
                Image(
                    painter = painterResource(id = R.drawable.moto2),
                    contentDescription = "Imagem de uma moto",
                    modifier = Modifier.padding(30.dp)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.moto3),
                contentDescription = "Imagem de uma moto",
                modifier = Modifier.padding(30.dp)
            )
        }
    )
}