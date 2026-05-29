package com.example.calculadora.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadora.components.Teclado

@Composable
fun CalculatorScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { paint ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paint)
        ) {
            Teclado()
        }
    }
}

@Preview
@Composable
fun CalculatorScreenPreview() {
    CalculatorScreen()
}