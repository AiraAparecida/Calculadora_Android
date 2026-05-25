package com.example.calculadora
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CalculatorLogicTest {
    private val calculatorLogic = CalculatorLogic()

    @Test
    fun adicao(){
        val a = 2.0
        val b = 3.0
        val resultado = 5.0
        assertEquals(resultado, calculatorLogic.adicao(a, b), 0.0)
    }

    @Test
    fun subtracao(){
        val a = 5.0
        val b = 3.0
        val resultado = 2.0
        assertEquals(resultado, calculatorLogic.subtracao(a, b), 0.0)
    }

    @Test
    fun multiplicacao(){
        val a = 2.0
        val b = 3.0
        val resultado = 6.0
        assertEquals(resultado, calculatorLogic.multiplicacao(a, b), 0.0)
    }

    @Test
    fun divisao(){
        val a = 6.0
        val b = 3.0
        val resultado = 2.0
        assertEquals(resultado, calculatorLogic.divisao(a, b), 0.0)
    }

    @Test
    fun porcentagem(){
        val a = 50.0
        val b = 20.0
        val resultado = 0.7
        assertEquals(resultado, calculatorLogic.porcentagem(a, b), 0.0)
    }

//    private val calculatorLogic = CalculatorLogic()
//
//    @Test
//    fun testAddition() {
//        assertEquals(5.0, calculatorLogic.add(2.0, 3.0), 0.001)
//    }
//
//    @Test
//    fun testSubtraction() {
//        assertEquals(1.0, calculatorLogic.subtract(5.0, 4.0), 0.001)
//    }
//
//    @Test
//    fun testMultiplication() {
//        assertEquals(6.0, calculatorLogic.multiply(2.0, 3.0), 0.001)
//    }
//
//    @Test
//    fun testDivision() {
//        assertEquals(2.0, calculatorLogic.divide(6.0, 3.0), 0.001)
//    }
//
//    @Test(expected = IllegalArgumentException::class)
//    fun testDivisionByZero() {
//        calculatorLogic.divide(5.0, 0.0)
//    }
}