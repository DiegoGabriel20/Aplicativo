package com.example.garagemapp.ui.screens.util

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

object Textos {
    @Composable
    fun TextShadow(
        text: String,               // Texto que será exibido
        shadowColor: Color,          // Cor da sombra
        offsetX: Float,              // Deslocamento no eixo X
        offsetY: Float,              // Deslocamento no eixo Y
        blurRadius: Float            // Raio do desfoque
    ) {
        val offset = Offset(offsetX, offsetY)
        Text(
            text = text,
            style = TextStyle(
                fontSize = 28.sp,     // Tamanho do texto
                shadow = Shadow(
                    color = shadowColor,
                    offset = offset,
                    blurRadius = blurRadius
                )
            )
        )
    }
}
