package br.edu.up.garagemapp

import GaragemViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.edu.up.garagemapp.data.repositorio.LocalRepository
import br.edu.up.garagemapp.data.lembrar.GaragemDB.Companion.getInstance
import br.edu.up.garagemapp.ui.Navegar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inicialize o banco de dados local
        val db = getInstance(this)

        // Configure o repositório local
        val localRepository = LocalRepository(db.reminderDao())

        // Inicialize o ViewModel usando apenas o repositório local
        val viewModel = GaragemViewModel(localRepository)

        setContent {
            Navegar(viewModel)
        }
    }
}
