package com.example.calculadora

import androidx.compose.ui.test.junit4.v2.createComposeRule
import com.example.calculadora.components.Keyboard
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import kotlin.test.Test

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class KeyboardTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testKeyboard() {
        composeRule.setContent {
            Keyboard()
        }
    }
}