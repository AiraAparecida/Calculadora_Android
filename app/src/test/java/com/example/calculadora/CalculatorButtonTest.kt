package com.example.calculadora

import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onRoot
import com.example.calculadora.components.CalculatorButton
import com.github.takahirom.roborazzi.RoborazziRule
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class CalculatorButtonTest {
    @get:Rule
    val composeRule = createComposeRule()

    @get:Rule
    val roborazziRule = RoborazziRule()

    @Test
    fun testCalculatorButton() {
        composeRule.setContent {
            CalculatorButton(
                label = "1",
                onClick = { }
            )
        }

        composeRule.waitForIdle()
        composeRule.onRoot().captureRoboImage()
    }
}