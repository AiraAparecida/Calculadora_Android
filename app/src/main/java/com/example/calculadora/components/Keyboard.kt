package com.example.calculadora.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadora.CalculatorParser
import com.example.calculadora.CalculatorParser.addOperation

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Keyboard() {
    var number by remember { mutableStateOf("") }

    val operates = listOf("+", "-", "x", "÷", "%")

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

        OutlinedTextField(
            value = number,
            onValueChange = { number = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 8.dp)
                .align(Alignment.End),
            textStyle = MaterialTheme.typography.displayMedium,
        )

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
                                    "C" -> number = ""
                                    "⌫" -> number = number.dropLast(1)
                                    "=" -> {
                                        number = CalculatorParser.calculator(number)
                                    }

                                    else -> {
                                        if (addOperation(number, key, operates)) {
                                            number = number + key
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