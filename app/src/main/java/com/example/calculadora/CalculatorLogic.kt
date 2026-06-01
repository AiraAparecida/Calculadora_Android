package com.example.calculadora

object CalculatorLogic {
    fun adicao(a: Double, b: Double): Double {
        return a + b
    }

    fun subtracao(a: Double, b: Double): Double {
        return a - b
    }

    fun multiplicacao(a: Double, b: Double): Double {
        return a * b
    }

    fun divisao(a: Double, b: Double): Double {
        if (b == 0.0) {
            throw IllegalArgumentException("Divisão por zero não é permitida.")
        }
        return a / b
    }

    fun porcentagem(a: Double, b: Double): Double {
        return a * (b / 100.0)
    }
}