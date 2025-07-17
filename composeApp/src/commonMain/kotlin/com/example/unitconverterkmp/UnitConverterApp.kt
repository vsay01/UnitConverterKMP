package com.example.unitconverterkmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import unitconverterkmp.composeapp.generated.resources.Res
import unitconverterkmp.composeapp.generated.resources.compose_multiplatform

@Composable
fun UnitConverterApp(viewModel: ConverterViewModel) {
    val state by viewModel.state.collectAsState()

    MaterialTheme {
        Column {
            TextField(
                value = state.inputValue,
                onValueChange = viewModel::onInputChange,
                label = { Text("Enter value") }
            )

            UnitDropdown("From", state.fromUnit, viewModel::onFromUnitChange)
            UnitDropdown("To", state.toUnit, viewModel::onToUnitChange)

            Text("Result: ${state.result}")
        }
    }
}

@Composable
fun UnitDropdown(label: String, selected: UnitType, onSelected: (UnitType) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Text(label)
        Button(onClick = { expanded = true }) {
            Text(selected.label)
        }
        DropdownMenu(
            expanded = expanded, // Corrected line
            onDismissRequest = { expanded = false }
        ) {
            UnitType.entries.forEach {
                DropdownMenuItem(
                    text = { Text(it.label) }, // Modern Material 3 way to set text
                    onClick = {
                        onSelected(it)
                        expanded = false
                    }
                )
            }
        }
    }
}