package com.example.calculadora

import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorParserTest{
    @Test
    fun somarDois() {
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

    @Test
    fun adeSuMult() {
        val resultado = CalculatorParser.calculator("1+3-2x4")
        assertEquals("-4.0", resultado)
    }

    @Test
    fun somaPlusMult() {
        val resultado = CalculatorParser.calculator("2+3x4")
        assertEquals("14.0", resultado)
    }

    @Test
    fun subtraiPlusDivisao() {
        val resultado = CalculatorParser.calculator("10-2÷2")
        assertEquals("9.0", resultado)
    }

    @Test
    fun calculoComplexo() {
        val resultado = CalculatorParser.calculator("1+2+1")
        assertEquals("4.0", resultado)
    }

    @Test
    fun calculoComSubtracao() {
        val resultado = CalculatorParser.calculator("1+2-1")
        assertEquals("2.0", resultado)
    }

    @Test
    fun calculoComplexoComMultiplicacao() {
        val resultado = CalculatorParser.calculator("2+3x4-1")
        assertEquals("13.0", resultado)
    }

    @Test
    fun divisaoPorZero() {
        val resultado = CalculatorParser.calculator("5÷0")
        assertEquals("0.0", resultado)
    }
}