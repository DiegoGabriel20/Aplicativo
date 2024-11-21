
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.up.garagemapp.data.lembrar.GaragemInfo
import br.edu.up.garagemapp.data.repositorio.IRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GaragemViewModel(
    private val repository: IRepository,
) : ViewModel() {

    private val _reminders = MutableStateFlow<List<GaragemInfo>>(emptyList())
    val reminders: StateFlow<List<GaragemInfo>> get() = _reminders

    private val _carros = MutableStateFlow<List<GaragemInfo>>(emptyList())
    val carros: StateFlow<List<GaragemInfo>> get() = _carros

    private val _motos = MutableStateFlow<List<GaragemInfo>>(emptyList())
    val motos: StateFlow<List<GaragemInfo>> get() = _motos

    init {
        viewModelScope.launch {
            refreshReminders()
        }
    }

    fun add(garagemInfo: GaragemInfo) {
        viewModelScope.launch {
            repository.add(garagemInfo)
            refreshReminders()
        }
    }

    fun remove(garagemInfo: GaragemInfo) {
        viewModelScope.launch {
            repository.remove(garagemInfo)
            refreshReminders()
        }
    }

    suspend fun search(reminderId: Int): GaragemInfo? {
        return withContext(Dispatchers.IO) {
            repository.search(reminderId)
        }
    }

    private fun refreshReminders() {
        viewModelScope.launch {
            val allReminders = repository.list().first()
            _reminders.value = allReminders
            _carros.value = allReminders.filterByType("Carro")
            _motos.value = allReminders.filterByType("Moto")
        }
    }

    // Extensão para filtrar lembretes por tipo
    private fun List<GaragemInfo>.filterByType(type: String): List<GaragemInfo> {
        return this.filter { it.tipo == type }
    }
}
