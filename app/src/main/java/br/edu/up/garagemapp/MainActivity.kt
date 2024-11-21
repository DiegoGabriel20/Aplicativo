package br.edu.up.garagemapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.edu.up.garagemapp.data.lembrar.GaragemDB.Companion.getInstance
import br.edu.up.garagemapp.data.repositorio.LocalRepository
import br.edu.up.garagemapp.data.repositorio.FirebaseRepository
import br.edu.up.garagemapp.data.repositorio.GaragemViewModel
import br.edu.up.garagemapp.ui.Navegar

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Defina se você quer usar o repositório local ou o Firebase
        val isLocal = false  // Altere para 'true' para usar LocalRepository

        // Inicialize o banco de dados local
        val db = getInstance(this)

        // Configure os repositórios
        val localRepository = LocalRepository(db.reminderDao())
        val firebaseRepository = FirebaseRepository()

        // Inicialize o ViewModel com o repositório adequado
        val viewModel: GaragemViewModel
        if (isLocal) {
            viewModel = GaragemViewModel(application, localRepository)
        } else {
            viewModel = GaragemViewModel(application, firebaseRepository)
        }

        // Configure o Composable com o ViewModel
        setContent {
            Navegar(viewModel)
        }
    }
}
