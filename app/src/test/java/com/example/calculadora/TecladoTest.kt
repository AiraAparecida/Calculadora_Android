package com.example.calculadora

import androidx.compose.ui.test.junit4.v2.createComposeRule
import com.example.calculadora.components.Teclado
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import kotlin.test.Test

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class TecladoTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testTeclado() {
        composeRule.setContent {
            Teclado(
                onKeyClick = { /* Ação de clique */ }
            )
        }
    }
}