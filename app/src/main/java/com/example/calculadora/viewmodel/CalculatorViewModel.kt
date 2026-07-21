package com.example.calculadora.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.calculadora.CalculatorParser

class CalculatorViewModel : ViewModel() {

    var cifra by mutableStateOf("")
        private set

    var isCalculated by mutableStateOf(false)
        private set

    var erroTrigger by mutableStateOf(0)
        private set

    var mensagemErro by mutableStateOf("")
        private set

    val result: String
        get() {
            if (isCalculated) return ""
            val rawResult = CalculatorParser.calculator(cifra)
            return if (rawResult == "Erro: Divisão por zero" || cifra.contains("÷0")) {
                ""
            } else {
                rawResult
            }
        }

    fun onKeyClick(key: String) {
        val operates = listOf("+", "-", "x", "÷", "%")

        when (key) {
            "C" -> {
                cifra = ""
                isCalculated = false
            }

            "⌫" -> {
                cifra = cifra.dropLast(1)
                isCalculated = false
            }

            "=" -> {
                if (cifra.contains("÷0")) {
                    mensagemErro = "Não é possível dividir por zero."
                    erroTrigger++
                } else {
                    val resultFinal = CalculatorParser.calculator(cifra)
                    if (resultFinal == "Erro: Divisão por zero") {
                        mensagemErro = "Não é possível dividir por zero."
                        erroTrigger++
                    } else {
                        cifra = resultFinal
                        isCalculated = true
                    }
                }
            }

            else -> {
                if (cifra.isEmpty() && key in operates) {
                    mensagemErro = "Formato usado inválido"
                    erroTrigger++
                    return
                }

                if (key !in operates && key != "=") {
                    val ultimoOperadorIndex = cifra.lastIndexOfAny(operates)
                    val ultimoNumero = if (ultimoOperadorIndex != -1) {
                        cifra.substring(ultimoOperadorIndex + 1)
                    } else {
                        cifra
                    }

                    if (ultimoNumero.length >= 15) {
                        mensagemErro = "Não é possivel inserir mais de 15 dígitos"
                        erroTrigger++
                        return
                    }
                }

                if (isCalculated) {
                    if (key in operates) {
                        isCalculated = false
                        cifra += key
                    } else {
                        isCalculated = false
                        cifra = if (key == ".") "0." else key
                    }
                } else {
                    if (key == ".") {
                        val ultimoOperadorIndex = cifra.lastIndexOfAny(operates)
                        val ultimoNumero = if (ultimoOperadorIndex != -1) {
                            cifra.substring(ultimoOperadorIndex + 1)
                        } else {
                            cifra
                        }

                        if (ultimoNumero.contains(".")) return

                        if (cifra.isEmpty() || cifra.last().toString() in operates) {
                            cifra += "0."
                            return
                        }
                    }

                    val rows = listOf(operates)
                    if (CalculatorParser.addOperation(cifra, key, rows)) {
                        cifra = CalculatorParser.replaceOperation(cifra, key)
                    } else {
                        cifra += key
                    }
                }
            }
        }
    }
}