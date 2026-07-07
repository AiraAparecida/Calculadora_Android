package com.example.calculadora

object CalculatorParser {

    fun calculator(express: String): String {
        return try {
            var exp = express.replace(" ", "")

            for (op in listOf("x", "÷", "%")) {
                exp = processAllOperators(exp, op)
            }

            for (op in listOf("+", "-")) {
                exp = processAllOperators(exp, op)
            }

            exp

        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    private fun processAllOperators(express: String, op: String): String {
        var result = express
        var latestResult: String

        do {
            latestResult = result
            result = processAOperator(result, op)
        } while (result != latestResult)

        return result
    }

    private fun processAOperator(
        express: String,
        op: String
    ): String {
        var indexOp = express.indexOf(op)

        if (indexOp == -1) return express

        if (indexOp == 0 && op == "-") {
            indexOp = express.indexOf(op, 1)
        }

        if (indexOp == -1) return express

        var startNum1 = indexOp - 1
        var endNum2 = indexOp + 1

        while (startNum1 >= 0 && (express[startNum1].isDigit() || express[startNum1] == '.')) {
            startNum1--
        }
        startNum1++

        while (endNum2 < express.length && (express[endNum2].isDigit() || express[endNum2] == '.')) {
            endNum2++
        }

        val num1String = express.substring(startNum1, indexOp)
        val num2String = express.substring(indexOp + 1, endNum2)

        val num1 = num1String.toDoubleOrNull() ?: return express
        val num2 = num2String.toDoubleOrNull() ?: return express

        if (op == "÷" && num2 == 0.0) {
            return "Erro: Divisão por zero"
        }

        val result = when (op) {
            "+" -> CalculatorLogic.adicao(num1, num2)
            "-" -> CalculatorLogic.subtracao(num1, num2)
            "x" -> CalculatorLogic.multiplicacao(num1, num2)
            "÷" -> CalculatorLogic.divisao(num1, num2)
            "%" -> CalculatorLogic.porcentagem(num1, num2)
            else -> 0.0
        }

        val resultFormatted = CalculatorLogic.formatarResultado(result)

        return express.substring(0, startNum1) + resultFormatted + express.substring(endNum2)
    }

    fun addOperation(
        cifra: String,
        key: String,
        rows: List<List<String>>
    ): Boolean {
        if (!rows.any { it.contains(key) }) return true
        if (cifra.isEmpty()) return false

        val ultimo = cifra.last().toString()
        return !rows.any { it.contains(ultimo) }
    }

    fun replaceOperation(
        cifra: String,
        key: String
    ): String {
        val operates = listOf("+", "-", "x", "÷", "%")

        if (cifra.isEmpty()) return key

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