package com.example.calculadora.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Teclado() {
    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ){
        ButtonCalculadora(label = "⌫", onClick = {})
        Spacer(modifier = Modifier.width(6.dp))
        ButtonCalculadora(label = "C", onClick = {})
        Spacer(modifier = Modifier.width(6.dp))
        ButtonCalculadora(label = "%", onClick = {})
        Spacer(modifier = Modifier.width(6.dp))
        ButtonCalculadora(label = "÷", onClick = {})
    }

    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ){
        ButtonCalculadora(label = "7", onClick = {})
        Spacer(modifier = Modifier.width(6.dp))
        ButtonCalculadora(label = "8", onClick = {})
        Spacer(modifier = Modifier.width(6.dp))
        ButtonCalculadora(label = "9", onClick = {})
        Spacer(modifier = Modifier.width(6.dp))
        ButtonCalculadora(label = "x", onClick = {})
    }

    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ){
        ButtonCalculadora(label = "4", onClick = {})
        Spacer(modifier = Modifier.width(6.dp))
        ButtonCalculadora(label = "5", onClick = {})
        Spacer(modifier = Modifier.width(6.dp))
        ButtonCalculadora(label = "6", onClick = {})
        Spacer(modifier = Modifier.width(6.dp))
        ButtonCalculadora(label = "-", onClick = {})
    }

    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ){
        ButtonCalculadora(label = "1", onClick = {})
        Spacer(modifier = Modifier.width(6.dp))
        ButtonCalculadora(label = "2", onClick = {})
        Spacer(modifier = Modifier.width(6.dp))
        ButtonCalculadora(label = "3", onClick = {})
        Spacer(modifier = Modifier.width(6.dp))
        ButtonCalculadora(label = "+", onClick = {})
    }

    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ){
        ButtonCalculadora(label = "-", onClick = {})
        Spacer(modifier = Modifier.width(6.dp))
        ButtonCalculadora(label = "0", onClick = {})
        Spacer(modifier = Modifier.width(6.dp))
        ButtonCalculadora(label = ",", onClick = {})
        Spacer(modifier = Modifier.width(6.dp))
        ButtonCalculadora(label = "=", onClick = {})
    }
}

@Preview
@Composable
fun TecladoPreview() {
    Teclado()
}