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
                    result = CalculatorLogic.adicao(a, b).toDouble()
                }

                express.contains("-") -> {
                    val parts = express.split("-")
                    val a = parts[0].toDouble()
                    val b = parts[1].toDouble()
                    result = CalculatorLogic.subtracao(a, b).toDouble()
                }

                express.contains("x") -> {
                    val parts = express.split("x")
                    val a = parts[0].toDouble()
                    val b = parts[1].toDouble()
                    result = CalculatorLogic.multiplicacao(a, b).toDouble()
                }

                express.contains("÷") -> {
                    val parts = express.split("÷")
                    val a = parts[0].toDouble()
                    val b = parts[1].toDouble()
                    result = CalculatorLogic.divisao(a, b).toDouble()
                }

                express.contains("%") -> {
                    val parts = express.split("%")
                    val a = parts[0].toDouble()
                    val b = parts[1].toDouble()
                    result = CalculatorLogic.porcentagem(a, b).toDouble()
                }

                else -> {
                    result = 0.0
                }

            }

            result.toString()

        } catch (e: Exception) {
            ""
        }
    }

//    fun addOperation(
//        caracter: String,
//        key: String,
//        rows: List<List<String>>
//    ): Boolean {
//        if (!rows.any {it.contains(key) } ) return true
//        if (caracter.isEmpty()) return false
//
//        val ultimo = caracter.last().toString()
//        val ultimoOP =
//
//        return !rows.any({it.contains(ultimo) })
//        return !rows.any({it.contains(ultimoOP)})
//    }

    fun replaceOperation(
        cifra: String,
        key: String
    ): String {
        val operates = listOf("+", "-", "x", "÷", "%")

        if (cifra.isEmpty()) return key
        //operates.contains(key) || key == "="

        val ultimo = cifra.last().toString()

        return when {
            operates.contains(key) && operates.contains(ultimo) -> {
                cifra.dropLast(1) + key
            }

            key == "=" && operates.contains(ultimo) -> {
                cifra
            }

            else -> {
                cifra + key
            }
        }
    }

}
