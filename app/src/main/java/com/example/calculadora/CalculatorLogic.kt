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
        return a / b
    }

    fun porcentagem(a: Double, b: Double): Double {
        return a * (b / 100.0)
    }

    fun formatarResultado(valor: Double): String {
        return if (valor == valor.toLong().toDouble()) {
            valor.toLong().toString()
        } else {
            valor.toString()
        }
    }
}