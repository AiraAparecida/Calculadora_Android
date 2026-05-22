package com.example.calculadora.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonCalculadora(
    onClick: () -> Unit,
    label: String = ""
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(90.dp)
            .height(90.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black,
disabledContainerColor     = Color.LightGray,  )
    ) {
        Text(text = label)
    }
}

@Preview(
    widthDp = 90,
    heightDp = 90
)
@Composable
fun ButtonCalculadoraPreview(){
    ButtonCalculadora(
     onClick = {}
    )
}