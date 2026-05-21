package com.example.calculadora
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.Assert

class CalculatorLogicTest {
    @Test
    fun adicao(){
        val a = 2.0
        val b = 3.0
        val resultado = 5.0
        val calculatorLogic = CalculatorLogic()
        assertEquals(resultado, calculatorLogic.adicao(a, b), 0.0)
    }

    @Test
    fun subtracao(){
        val a = 5.0
        val b = 3.0
        val resultado = 2.0
        val calculatorLogic = CalculatorLogic()
        assertEquals(resultado, calculatorLogic.subtracao(a, b), 0.0)
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