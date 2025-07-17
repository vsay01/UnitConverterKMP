package com.example.unitconverterkmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val viewModel = ConverterViewModel()
        setContent {
            UnitConverterApp(viewModel)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val viewModel = ConverterViewModel()
    UnitConverterApp(viewModel)
}