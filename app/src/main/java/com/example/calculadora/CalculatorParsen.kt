package com.example.calculadora

import androidx.compose.runtime.Composable

@Composable
fun calcular(express: String): String {
     return try {
        val result: Double
        when {
            express.contains("+") -> {
                val parts = express.split("+")
                val a = parts[0].toDouble()
                val b = parts[1].toDouble()
                result = CalculatorLogic().adicao(a, b)
            }

            express.contains("-") -> {
                val parts = express.split("-")
                val a = parts[0].toDouble()
                val b = parts[1].toDouble()
                result = CalculatorLogic().subtracao(a, b)
            }

            express.contains("x") -> {
                val parts = express.split("x")
                val a = parts[0].toDouble()
                val b = parts[1].toDouble()
                result = CalculatorLogic().multiplicacao(a, b)
            }

            express.contains("÷") -> {
                val parts = express.split("÷")
                val a = parts[0].toDouble()
                val b = parts[1].toDouble()
                result = CalculatorLogic().divisao(a, b)
            }

            express.contains("%") -> {
                val parts = express.split("%")
                val a = parts[0].toDouble()
                val b = parts[1].toDouble()
                result = CalculatorLogic().porcentagem(a, b)
            }

            else -> {
                result = 0.0
            }

        }

        result.toString()

    } catch (e: Exception) {
        "Error"
    }
}