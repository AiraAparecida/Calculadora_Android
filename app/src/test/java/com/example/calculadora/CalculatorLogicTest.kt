package com.example.calculadora

import junit.framework.TestCase.assertEquals
import org.junit.Test

class CalculatorLogicTest {
    private val calculatorLogic = CalculatorLogic

    @Test
    fun adicao() {
        val a = 2.0
        val b = 3.0
        val resultado = 5.0
        assertEquals(resultado, calculatorLogic.adicao(a, b), 0.0)
    }

    @Test
    fun subtracao() {
        val a = 5.0
        val b = 3.0
        val resultado = 2.0
        assertEquals(resultado, calculatorLogic.subtracao(a, b), 0.0)
    }

    @Test
    fun multiplicacao() {
        val a = 2.0
        val b = 3.0
        val resultado = 6.0
        assertEquals(resultado, calculatorLogic.multiplicacao(a, b), 0.0)
    }

    @Test
    fun divisao() {
        val a = 6.0
        val b = 3.0
        val resultado = 2.0
        assertEquals(resultado, calculatorLogic.divisao(a, b), 0.0)
    }

    @Test
    fun porcentagem() {
        val a = 50.0
        val b = 20.0
        val resultado = 10.0
        assertEquals(resultado, calculatorLogic.porcentagem(a, b), 0.0)
    }
}