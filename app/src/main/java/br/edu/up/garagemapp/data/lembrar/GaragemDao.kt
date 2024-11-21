package br.edu.up.garagemapp.data.lembrar

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface GaragemDao {

    @Query("SELECT * FROM garageminfo")
    fun listReminders(): Flow<List<GaragemInfo>>

    @Upsert
    suspend fun addReminder(garagemInfo: GaragemInfo)

    @Query("SELECT * FROM garagemInfo WHERE id = :id")
    suspend fun searchReminder(id: Int): GaragemInfo

    @Delete
    suspend fun removeReminder(garagemInfo: GaragemInfo)
}
