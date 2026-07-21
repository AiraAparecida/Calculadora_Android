package com.example.calculadora.components

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadora.viewmodel.CalculatorViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Keyboard(viewModel: CalculatorViewModel) {
    val context = LocalContext.current

    LaunchedEffect(viewModel.erroTrigger) {
        if (viewModel.erroTrigger > 0 && viewModel.mensagemErro.isNotEmpty()) {
            Toast.makeText(context, viewModel.mensagemErro, Toast.LENGTH_SHORT).show()
        }
    }

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
            value = viewModel.cifra,
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 8.dp)
                .align(Alignment.End),
            textStyle = MaterialTheme.typography.displayMedium.copy(textAlign = TextAlign.End),
        )
        if (viewModel.result.isNotEmpty()) {
            Text(
                text = viewModel.result,
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
                                viewModel.onKeyClick(key)
                            })
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KeyboardPreview() {
    val previewViewModel = CalculatorViewModel()
    Keyboard(viewModel = previewViewModel)
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun KeyboardPreviewDark() {
    val previewViewModel = CalculatorViewModel()
    Keyboard(viewModel = previewViewModel)
}