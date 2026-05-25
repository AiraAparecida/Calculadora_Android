package com.example.calculadora

import androidx.compose.material3.Text
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class CalculatorScreenTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testCalculatorScreen() {
        composeRule.setContent {
            Text("Tela Inicial")
        }

        composeRule.onRoot().captureRoboImage("calculator_screen.png")
    }
}