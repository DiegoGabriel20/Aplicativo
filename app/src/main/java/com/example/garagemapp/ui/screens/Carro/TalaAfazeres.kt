package br.edu.up.Garagem.ui.screens.Carro

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.Garagem.ui.screens.util.PlannerTopBar
import br.edu.up.Garagem.ui.screens.util.TelaUmBottomBar
import com.example.garagemapp.R

object TarefasRota {
    val TELA_LISTAR_AFAZERES_ROTA = "listar_afazeres"
    val TELA_INCLUIR_AFAZER_ROTA = "incluir_afazer"
}


@Composable
fun TelaAfazeres(
    drawerState: DrawerState,
    navCtrlBottomNav: NavController
) {

    var afazeres = mutableListOf(
        Afazer(
            titulo = "Comprar um carro",
            descricao = "Visitar concessionárias",
            id = 1
        ),
        Afazer(
            titulo = "Lavar o Carro",
            descricao = "Passar na Revisão",
            id = 2
        )
    )

    val navCtrlTarefas = rememberNavController()


    Scaffold(
        topBar = { PlannerTopBar(drawerState) },
        content = { padding ->  padding
            NavHost(
                navController = navCtrlTarefas,
                startDestination = TarefasRota.TELA_LISTAR_AFAZERES_ROTA)
            {
                composable(TarefasRota.TELA_LISTAR_AFAZERES_ROTA) {
                    TelaListagemCarros(afazeres)
                }
                composable(TarefasRota.TELA_INCLUIR_AFAZER_ROTA) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Spacer(modifier = Modifier.height(200.dp))
                        Text(text = "TELA DE INCLUIR AFAZER")
                    }
                }
            }


        },
        floatingActionButton = { FloatButton() },
        bottomBar = { TelaUmBottomBar(navCtrlBottomNav) }
    )
}

@Composable
private fun TelaListagemCarros(afazeres: MutableList<Afazer>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(afazeres) { afazer ->
            Text(
                text = afazer.titulo,
                Modifier.padding(20.dp),
                fontSize = 20.sp
            )
        }
    }
}

data class Afazer(
    var titulo: String,
    var descricao: String,
    var concluido: Boolean = false,
    var id: Int? = null
)


@Composable
private fun FloatButton() {
    FloatingActionButton(onClick = { }) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "+"
        )
    }
}


