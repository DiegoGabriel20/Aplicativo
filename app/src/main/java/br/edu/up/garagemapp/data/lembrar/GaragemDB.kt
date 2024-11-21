package br.edu.up.garagemapp.data.lembrar

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [GaragemInfo::class], version = 2, exportSchema = true)
abstract class GaragemDB : RoomDatabase() {

    abstract fun reminderDao(): GaragemDao

    companion object {
        // Define a migração da versão 1 para a versão 2
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Adiciona as colunas 'tipo' e 'imagem' à tabela GaragemInfo
                database.execSQL("ALTER TABLE GaragemInfo ADD COLUMN tipo TEXT DEFAULT '' NOT NULL")
                database.execSQL("ALTER TABLE GaragemInfo ADD COLUMN imagem TEXT DEFAULT '' NOT NULL")
            }
        }

        // Cria ou retorna uma instância do banco de dados
        @Volatile
        private var INSTANCE: GaragemDB? = null

        fun getInstance(context: Context): GaragemDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GaragemDB::class.java,
                    "reminder.db"
                )
                    .addMigrations(MIGRATION_1_2) // Adiciona a migração
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
