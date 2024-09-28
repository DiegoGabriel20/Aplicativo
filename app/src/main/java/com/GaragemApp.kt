import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.edu.up.Garagem.ui.screens.Adicionar.TelaAdicionar
import br.edu.up.Garagem.ui.screens.Carro.TelaCarro
import br.edu.up.Garagem.ui.screens.Carro.TelaMoto
import com.example.garagemapp.R
import com.example.garagemapp.ui.screens.TelaPrincipal.TelaBarco
import com.example.garagemapp.ui.screens.util.Textos


object GaragemRotas {
    const val TELA_CARRO_ROTA = "tela_carro"
    const val TELA_MOTO_ROTA = "tela_moto"
    const val TELA_BARCO_ROTA = "tela_barco"
    const val TELA_ADICIONAR_ROTA = "tela_adicionar" // Nova rota para a ação

}

@Preview
@Composable
fun Garagem() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar(navController) },
        floatingActionButton = { Example(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = GaragemRotas.TELA_CARRO_ROTA,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(GaragemRotas.TELA_CARRO_ROTA) { TelaCarro() }
            composable(GaragemRotas.TELA_MOTO_ROTA) { TelaMoto() }
            composable(GaragemRotas.TELA_BARCO_ROTA) { TelaBarco() }
            composable(GaragemRotas.TELA_ADICIONAR_ROTA) { TelaAdicionar(navController) }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    val textos = Textos() // Supondo que Textos é uma classe que você criou

    CenterAlignedTopAppBar(
        title = {
            textos.TextShadow(
                text = "Minha Garagem",
                shadowColor = Color.DarkGray,
                offsetX = 10f,
                offsetY = 10f,
                blurRadius = 8f
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF0C8CD4),
            titleContentColor = Color.White
        )
    )
}
@Composable
fun BottomBar(navController: NavController) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = Color(0xFF0C8CD4)
    ) {
        NavigationBarItem(
            selected = currentRoute == GaragemRotas.TELA_CARRO_ROTA,
            onClick = {
                navController.navigate(GaragemRotas.TELA_CARRO_ROTA) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.carroicon),
                    contentDescription = "Ícone de Carro",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = {
                Text(
                    text = "Carros",
                    fontSize = 16.sp,
                    color = if (currentRoute == GaragemRotas.TELA_CARRO_ROTA) Color.Yellow else Color.White
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.Yellow,
                unselectedTextColor = Color.White
            )
        )

        NavigationBarItem(
            selected = currentRoute == GaragemRotas.TELA_MOTO_ROTA,
            onClick = {
                navController.navigate(GaragemRotas.TELA_MOTO_ROTA) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.motoicon),
                    contentDescription = "Ícone de Moto",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = {
                Text(
                    text = "Motos",
                    fontSize = 16.sp,
                    color = if (currentRoute == GaragemRotas.TELA_MOTO_ROTA) Color.Yellow else Color.White
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.Yellow,
                unselectedTextColor = Color.White
            )
        )

        NavigationBarItem(
            selected = currentRoute == GaragemRotas.TELA_BARCO_ROTA,
            onClick = {
                navController.navigate(GaragemRotas.TELA_BARCO_ROTA) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.barcoicon2),
                    contentDescription = "Ícone de Barco",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = {
                Text(
                    text = "Barcos",
                    fontSize = 16.sp,
                    color = if (currentRoute == GaragemRotas.TELA_BARCO_ROTA) Color.Yellow else Color.White
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.Yellow,
                unselectedTextColor = Color.White
            )
        )
    }
}
@Composable
fun Example(navController: NavController) {
    FloatingActionButton(
        onClick = { navController.navigate(GaragemRotas.TELA_ADICIONAR_ROTA) },
        containerColor = Color(0xFF4D1AB1),
        contentColor = Color.White
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}



