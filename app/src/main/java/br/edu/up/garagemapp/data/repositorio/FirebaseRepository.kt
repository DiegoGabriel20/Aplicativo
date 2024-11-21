package br.edu.up.garagemapp.data.repositorio

import android.util.Log
import br.edu.up.garagemapp.data.lembrar.GaragemInfo
import br.edu.up.garagemapp.data.lembrar.GaragemDB
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FirebaseRepository(private val garagemDB: GaragemDB) : IRepository {
    private val db = FirebaseFirestore.getInstance()

    // Adiciona no Firebase e no banco local
    override suspend fun add(garagemInfo: GaragemInfo) {
        try {
            // Adiciona no Firebase Firestore
            val documentReference = db.collection("garagens")
                .add(garagemInfo)
                .await()

            // Salva o ID do documento do Firebase no objeto para salvar no banco local
            garagemInfo.id = documentReference.id

            // Adiciona no banco local (SQLite)
            garagemDB.reminderDao().insert(garagemInfo)

            Log.d("Firebase", "Garagem salva com sucesso no Firebase e no banco local.")
        } catch (e: Exception) {
            Log.e("Firebase", "Erro ao salvar garagem no Firebase e no banco local", e)
        }
    }

    // Lista as garagens (do Firebase ou do banco local)
    override suspend fun list(): List<GaragemInfo> {
        val garagens = mutableListOf<GaragemInfo>()
        try {
            // Primeiro tenta buscar no banco local
            val garagensLocal = garagemDB.reminderDao().getAll()
            if (garagensLocal.isNotEmpty()) {
                garagens.addAll(garagensLocal)
            } else {
                // Se o banco local estiver vazio, busca no Firebase
                val snapshot = db.collection("garagens").get().await()
                for (document in snapshot) {
                    val garagem = document.toObject(GaragemInfo::class.java)
                    garagem.id = document.id  // Atribui o ID do Firebase
                    garagens.add(garagem)
                }
                // Opcionalmente, salva no banco local para futuras consultas
                garagens.forEach { garagemInfo ->
                    // Verifica se já não existe no banco local antes de inserir
                    if (garagemDB.reminderDao().getById(garagemInfo.id!!) == null) {
                        garagemDB.reminderDao().insert(garagemInfo)
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("Firebase", "Erro ao listar garagens", e)
        }
        return garagens
    }

    // Remove um documento do Firebase e do banco local
    override suspend fun remove(garagemInfo: GaragemInfo) {
        try {
            // Remove do Firebase
            db.collection("garagens").document(garagemInfo.id!!).delete().await()

            // Remove do banco local
            garagemDB.reminderDao().delete(garagemInfo)

            Log.d("Firebase", "Garagem removida com sucesso do Firebase e do banco local.")
        } catch (e: Exception) {
            Log.e("Firebase", "Erro ao remover garagem", e)
        }
    }
}
