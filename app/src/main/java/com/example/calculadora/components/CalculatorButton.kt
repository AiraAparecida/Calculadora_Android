package com.example.calculadora.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme

@Composable
fun CalculatorButton(
    onClick: () -> Unit,
    label: String = "",

) {
    AppTheme(dynamicColor = false) {
        Button(
            onClick = onClick,
            modifier = Modifier.width(90.dp).height(90.dp).padding(2.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = Color.Black,
                disabledContainerColor = Color.LightGray,
            )
        ) {
            Text(
                text = label,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize
            )
        }
    }
}

@Preview(
    widthDp = 90,
    heightDp = 90,
    showBackground = true
)
@Composable
fun CalculatorButtonPreview() {
    AppTheme {
        CalculatorButton(
            label = "7",
            onClick = {}
        )
    }
}

@Preview(
    widthDp = 90,
    heightDp = 90,
    name = "Tema Escuro",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun CalculatorButtonPreviewDark() {
    AppTheme {
        CalculatorButton(
            label = "7",
            onClick = {}
        )
    }

}