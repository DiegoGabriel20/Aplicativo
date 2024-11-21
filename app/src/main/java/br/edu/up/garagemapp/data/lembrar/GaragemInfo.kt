package br.edu.up.garagemapp.data.lembrar

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GaragemInfo(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val marca: String = "",
    val modelo: String = "",
    val ano: String = "",
    val tipo: String = "", // "Carro" ou "Moto"
    val imagem: String = ""
)
