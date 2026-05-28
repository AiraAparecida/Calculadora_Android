package com.example.calculadora.components

import android.R.attr.label
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.helper.widget.Grid

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

//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Bottom
//    ) {
//        Text(
//            text = "0",
//            textAlign = TextAlign.End,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 18.dp, vertical = 8.dp),
//            style = MaterialTheme.typography.displayLarge,
//        )
//
//        Column {
//            rows.forEach { row ->
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 8.dp, vertical = 4.dp),
//                    horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally)
//                ) {
//                    row.forEach { key ->
//                        ButtonCalculadora(
//                            label = key,
//                            onClick = {
//                                onKeyClick(key)
//                            })
//                        //label ->
//                        //ButtonCalculadora(label = label, onClick = { onKeyClick(label) })
//                    }
//                }
//            }
//        }
//    }



}

@Preview(
    showBackground = true
)
@Composable
fun TecladoPreview() {
    Teclado()
}