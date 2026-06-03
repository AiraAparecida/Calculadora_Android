package com.example.calculadora

object CalculatorParser {
    fun calculator(express: String): String {

        return try {
            val result: Double
            when {
                express.contains("+") -> {
                    val parts = express.split("+")
                    val a = parts[0].toDouble()
                    val b = parts[1].toDouble()
                    result = CalculatorLogic.adicao(a, b)
                }

                express.contains("-") -> {
                    val parts = express.split("-")
                    val a = parts[0].toDouble()
                    val b = parts[1].toDouble()
                    result = CalculatorLogic.subtracao(a, b)
                }

                express.contains("x") -> {
                    val parts = express.split("x")
                    val a = parts[0].toDouble()
                    val b = parts[1].toDouble()
                    result = CalculatorLogic.multiplicacao(a, b)
                }

                express.contains("÷") -> {
                    val parts = express.split("÷")
                    val a = parts[0].toDouble()
                    val b = parts[1].toDouble()
                    result = CalculatorLogic.divisao(a, b)
                }

                express.contains("%") -> {
                    val parts = express.split("%")
                    val a = parts[0].toDouble()
                    val b = parts[1].toDouble()
                    result = CalculatorLogic.porcentagem(a, b)
                }

                else -> {
                    result = 0.0
                }

            }

            result.toString()

        } catch (e: Exception) {
            "Error"
        }
    }

    //tramento de erro
    fun addOperation(
        number: String,
        key: String,
        operates: List<String>
    ): Boolean {
        if (!operates.contains(key)) return true

        if (number.isEmpty()) return false

        val ultimo = number.last().toString()

        return !operates.contains(ultimo)
    }

}