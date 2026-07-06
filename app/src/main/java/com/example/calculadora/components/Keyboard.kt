package com.example.calculadora.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadora.CalculatorParser

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Keyboard() {
    var cifra by remember { mutableStateOf("") }
    var isCalculated by remember { mutableStateOf(false) }
    val result = if (isCalculated) "" else CalculatorParser.calculator(cifra)

    val rows = listOf(
        listOf("⌫", "C", "%", "÷"),
        listOf("7", "8", "9", "x"),
        listOf("4", "5", "6", "-"),
        listOf("1", "2", "3", "+"),
        listOf("00", "0", ".", "=")
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {

        BasicTextField(
            value = cifra,
            onValueChange = {
                cifra = it
                isCalculated = false
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 8.dp)
                .align(Alignment.End),
            textStyle = MaterialTheme.typography.displayMedium.copy(textAlign = TextAlign.End),
        )
        if (result.isNotEmpty()) {
            Text(
                text = result,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp, vertical = 8.dp),
                style = MaterialTheme.typography.displaySmall.copy(textAlign = TextAlign.End),
                color = Color.Black.copy(alpha = 0.5f)
            )
        }

        Column {
            rows.forEach { row ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally)
                ) {
                    row.forEach { key ->
                        CalculatorButton(
                            label = key,
                            onClick = {
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
                                        val resultFinal = CalculatorParser.calculator(cifra)
                                        cifra = resultFinal
                                        isCalculated = true
                                    }

                                    else -> {
                                        val operates = listOf("+", "-", "x", "÷", "%")

                                        if (isCalculated) {
                                            if (key in operates) {
                                                isCalculated = false
                                                cifra += key
                                            } else {
                                                isCalculated = false
                                                cifra = key
                                            }
                                        } else {
                                            val rows = listOf(operates)
                                            if (CalculatorParser.addOperation(cifra, key, rows)) {
                                                cifra =
                                                    CalculatorParser.replaceOperation(cifra, key)
                                            } else {
                                                cifra += key
                                            }
                                        }
                                    }
                                }
                            })
                    }
                }
            }
        }
    }


}

@Preview(
    showBackground = true
)
@Composable
fun KeyboardPreview() {
    Keyboard()
}