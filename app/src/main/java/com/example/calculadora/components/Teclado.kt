package com.example.calculadora.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Teclado(
    onKeyClick: (String) -> Unit = {}
) {
    val rows = remember { listOf(
        listOf("⌫", "C", "%", "÷"),
        listOf("7", "8", "9", "x"),
        listOf("4", "5", "6", "-"),
        listOf("1", "2", "3", "+"),
        listOf(",", "0", ".", "=")
    )
    }

    Column {
        rows.forEach { row ->
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                row.forEach { key->
                    ButtonCalculadora(label = key, onClick = { onKeyClick(key) })
                    Spacer(modifier = Modifier.width(6.dp))
//                    label ->
//                    ButtonCalculadora(label = label, onClick = { onKeyClick(label) })
                }
            }
        }
    }
}





//    Row(
//        modifier = Modifier
//            .padding(horizontal = 8.dp, vertical = 4.dp)
//    ){
//        ButtonCalculadora(label = "⌫", onClick = {})
//        Spacer(modifier = Modifier.width(6.dp))
//        ButtonCalculadora(label = "C", onClick = {})
//        Spacer(modifier = Modifier.width(6.dp))
//        ButtonCalculadora(label = "%", onClick = {})
//        Spacer(modifier = Modifier.width(6.dp))
//        ButtonCalculadora(label = "÷", onClick = {})
//    }
//
//    Row(
//        modifier = Modifier
//            .padding(horizontal = 8.dp, vertical = 4.dp)
//    ){
//        ButtonCalculadora(label = "7", onClick = {})
//        Spacer(modifier = Modifier.width(6.dp))
//        ButtonCalculadora(label = "8", onClick = {})
//        Spacer(modifier = Modifier.width(6.dp))
//        ButtonCalculadora(label = "9", onClick = {})
//        Spacer(modifier = Modifier.width(6.dp))
//        ButtonCalculadora(label = "x", onClick = {})
//    }
//
//    Row(
//        modifier = Modifier
//            .padding(horizontal = 8.dp, vertical = 4.dp)
//    ){
//        ButtonCalculadora(label = "4", onClick = {})
//        Spacer(modifier = Modifier.width(6.dp))
//        ButtonCalculadora(label = "5", onClick = {})
//        Spacer(modifier = Modifier.width(6.dp))
//        ButtonCalculadora(label = "6", onClick = {})
//        Spacer(modifier = Modifier.width(6.dp))
//        ButtonCalculadora(label = "-", onClick = {})
//    }
//
//    Row(
//        modifier = Modifier
//            .padding(horizontal = 8.dp, vertical = 4.dp)
//    ){
//        ButtonCalculadora(label = "1", onClick = {})
//        Spacer(modifier = Modifier.width(6.dp))
//        ButtonCalculadora(label = "2", onClick = {})
//        Spacer(modifier = Modifier.width(6.dp))
//        ButtonCalculadora(label = "3", onClick = {})
//        Spacer(modifier = Modifier.width(6.dp))
//        ButtonCalculadora(label = "+", onClick = {})
//    }
//
//    Row(
//        modifier = Modifier
//            .padding(horizontal = 8.dp, vertical = 4.dp)
//    ){
//        ButtonCalculadora(label = "-", onClick = {})
//        Spacer(modifier = Modifier.width(6.dp))
//        ButtonCalculadora(label = "0", onClick = {})
//        Spacer(modifier = Modifier.width(6.dp))
//        ButtonCalculadora(label = ",", onClick = {})
//        Spacer(modifier = Modifier.width(6.dp))
//        ButtonCalculadora(label = "=", onClick = {})
//    }


@Preview
@Composable
fun TecladoPreview() {
    Teclado()
}