package br.edu.up.garagemapp.data.repositorio

import br.edu.up.garagemapp.data.lembrar.GaragemInfo
import br.edu.up.garagemapp.data.lembrar.GaragemDao
import kotlinx.coroutines.flow.Flow

class LocalRepository(private val dao: GaragemDao) : IRepository {

    override fun list(): Flow<List<GaragemInfo>> {
        return dao.listReminders()
    }

    override suspend fun add(garagemInfo: GaragemInfo) {
        dao.addReminder(garagemInfo)
    }

    override suspend fun search(idx: Int): GaragemInfo? {
        return dao.searchReminder(idx)
    }

    override suspend fun remove(garagemInfo: GaragemInfo) {
        dao.removeReminder(garagemInfo)
    }

}

