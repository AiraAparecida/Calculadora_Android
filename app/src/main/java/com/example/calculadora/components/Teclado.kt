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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadora.CalculatorLogic

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Teclado(
    onKeyClick: (String) -> Unit = {}
) {
    val rows = listOf(
        listOf("⌫", "C", "%", "÷"),
        listOf("7", "8", "9", "x"),
        listOf("4", "5", "6", "-"),
        listOf("1", "2", "3", "+"),
        listOf(",", "0", ".", "=")
    )


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        var number by remember { mutableStateOf("") }
        if (number.isEmpty()) {
            Text(
                text = "Calculadora $number",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge
            )
        }
        OutlinedTextField(
            value = number,
            onValueChange = { number = it},
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
                        ButtonCalculadora(
                            label = key,
                            onClick = {
                                onKeyClick(key)
                            })
                        when (key) {
                            "⌫" -> { /*Lógica para borrar o último dígito}*/
                            }

                            "C" -> { /*Lógica para limpiar*/
                            }

                            "%" -> {/*Lógica para calcular*/
                            }

                            "÷" -> {/*Lógica para calcular*/
                            }

                            "x" -> {/*Lógica para calcular*/
                            }

                            "-" -> {/*Lógica para calcular*/
                            }

                            "+" -> { ButtonCalculadora(label = key, onClick = { CalculatorLogic().adicao(a = 0.0, b = 0.0)}) /*Lógica para calcular*/}

                            "=" -> {/*Lógica para calcular*/
                            }
                            //"1" -> { ButtonCalculadora(label = key, onClick = { onKeyClick(key) }) }
                        }
                        //"⌫" -> ButtonCalculadora(label = key, onClick = { onKeyClick(key) })
                        //label ->
                        //ButtonCalculadora(label = label, onClick = { onKeyClick(label) })
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
fun TecladoPreview() {
    Teclado()
}