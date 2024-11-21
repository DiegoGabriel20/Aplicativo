package br.edu.up.garagemapp.data.repositorio

import br.edu.up.garagemapp.data.lembrar.GaragemInfo
import kotlinx.coroutines.flow.Flow

interface IRepository {

    fun list(): Flow<List<GaragemInfo>>

    suspend fun search(idx: Int): GaragemInfo?

    suspend fun add(garagemInfo: GaragemInfo)

    suspend fun remove(garagemInfo: GaragemInfo)

}
