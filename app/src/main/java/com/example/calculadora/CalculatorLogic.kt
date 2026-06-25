package com.example.calculadora

import java.text.DecimalFormat

object CalculatorLogic {
    fun adicao(a: Double, b: Double): String {
        val soma = a + b
        return DecimalFormat("#.##").format(soma)
    }

    fun subtracao(a: Double, b: Double): String {
        val menos = a - b.toInt()
        return DecimalFormat("#.##").format(menos)
    }

    fun multiplicacao(a: Double, b: Double): String {
        val mult = a * b.toInt()
        return DecimalFormat("#.##").format(mult)
    }

    fun divisao(a: Double, b: Double): String {
        if (b == 0.0) {
            throw IllegalArgumentException("Divisão por zero não é permitida.")
        }
        val div = a / b.toInt()
        return DecimalFormat("#.##").format(div)
    }

    fun porcentagem(a: Double, b: Double): String {
        val por = a * (b / 100.0).toInt()
        return DecimalFormat("#.##").format(por)
    }
}