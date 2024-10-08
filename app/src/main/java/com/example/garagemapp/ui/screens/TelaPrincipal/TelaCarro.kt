package br.edu.up.Garagem.ui.screens.Carro

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.garagemapp.R

data class Carro(val nome: String, val ano: String, val kilometragem: String, val imageResId: Int)

val carros = listOf(
    Carro("Toyota Supra", "1998", "125.850", R.drawable.carro2),
    Carro("Honda Civic", "2020", "30.000", R.drawable.civic), // Troque pelo recurso correto da imagem
    Carro("VolksWagen Golf", "2008", "40.000", R.drawable.golf)  // Troque pelo recurso correto da imagem
)

@Composable
fun TelaCarro() {
    Scaffold(
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
            ) {
                item {
                    Text(
                        text = "Meus Carros",
                        modifier = Modifier.padding(top = 40.dp),
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1A778A)
                    )
                }

                items(carros) { carro ->
                    CarroCard(
                        nome = carro.nome,
                        ano = carro.ano,
                        kilometragem = carro.kilometragem,
                        imageResId = carro.imageResId
                    )
                }
            }
        }
    )
}

@Composable
fun CarroCard(nome: String, ano: String, kilometragem: String, imageResId: Int) {
    Card(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1B84A4)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Imagem de um carro",
                modifier = Modifier
                    .size(200.dp)
                    .padding(bottom = 8.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = nome,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Deletar",
                    modifier = Modifier
                        .clickable { /* Ação para deletar o carro */ }
                        .padding(start = 8.dp)
                        .size(50.dp)
                )
            }
            Text(
                text = "Ano: $ano",
                fontSize = 24.sp,
                fontWeight = FontWeight.Light,
                color = Color.Black
            )
            Text(
                text = "Kilometragem rodada: $kilometragem",
                fontSize = 24.sp,
                fontWeight = FontWeight.Light,
                color = Color.Black
            )
        }
    }
}
