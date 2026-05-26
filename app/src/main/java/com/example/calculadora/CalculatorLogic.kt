package com.example.calculadora

class CalculatorLogic {
    //Adição
    fun adicao(a: Double, b: Double): Double {
        return a + b
    }

    //Subtração
    fun subtracao(a: Double, b: Double): Double {
        return a - b
    }

    //Multiplicação
    fun multiplicacao(a: Double, b: Double): Double {
        return a * b
    }

    //Divisão
    fun divisao(a: Double, b: Double): Double {
        if (b == 0.0) {
            throw IllegalArgumentException("Divisão por zero não é permitida.")
        }
        return a / b
    }

    //Porcentagem
    fun porcentagem(a: Double, b: Double): Double{
        return a * (b / 100.0)
    }
}