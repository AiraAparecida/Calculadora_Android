package com.example.calculadora

import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onRoot
import com.example.calculadora.components.ButtonCalculadora
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import kotlin.test.Test

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class ButtonCalculadoraTest{
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testButtonCalculadora(){
        composeRule.setContent {
            ButtonCalculadora(
                label = "1",
                onClick = { /* Ação de clique */ }
            )
        }
        composeRule.onRoot().captureRoboImage("button_calculadora.png")
    }
}

