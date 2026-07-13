package com.example.calculadora

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

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

    fun formatarResultado(value: Double): String {
        if (value.isInfinite() || value.isNaN()){
            return value.toString()
        }

        val bd = BigDecimal(value).setScale(10, RoundingMode.HALF_UP)

        val roundedValue = bd.toDouble()

        return if (roundedValue == roundedValue.toLong().toDouble()) {
            roundedValue.toLong().toString()
        } else {
            val numFormat = DecimalFormat("0.##########", DecimalFormatSymbols(Locale.US))
            numFormat.format(roundedValue)
        }
    }
}