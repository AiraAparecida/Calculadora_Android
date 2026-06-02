package com.example.calculadora

import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorParserTest{
    @Test
    fun somarDois(){
        val resultado = CalculatorParser.calculator("10+5")
        assertEquals("15.0", resultado)
    }

    @Test
    fun subtrairDois(){
        val resultado = CalculatorParser.calculator("17-5")
        assertEquals("12.0", resultado)
    }

    @Test
    fun multuplicarDois(){
        val resultado = CalculatorParser.calculator("6x4")
        assertEquals("24.0", resultado)
    }

    @Test
    fun dividirDois(){
        val resultado = CalculatorParser.calculator("8÷2")
        assertEquals("4.0", resultado)
    }

    @Test
    fun porcentagemDois(){
        val resultado = CalculatorParser.calculator("24%2")
        assertEquals("0.48", resultado)
    }
}