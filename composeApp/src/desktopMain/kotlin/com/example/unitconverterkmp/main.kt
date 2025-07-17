package com.example.unitconverterkmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "UnitConverterKMP",
    ) {
        val viewModel = remember { ConverterViewModel() }
        UnitConverterApp(viewModel)
    }
}