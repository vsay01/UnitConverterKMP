package com.example.unitconverterkmp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UnitConverterApp(viewModel: ConverterViewModel) {
    val state by viewModel.state.collectAsState()

    val unitsToDisplay: List<UnitType> =
        viewModel.availableUnits // Or remember { viewModel.availableUnits }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Unit Converter", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = state.inputValue,
            onValueChange = { viewModel.updateInput(it) },
            label = { Text("Enter value") }
        )

        Spacer(Modifier.height(8.dp))

        DropdownMenuBox(
            label = "From Unit",
            selected = state.fromUnit,
            options = unitsToDisplay, // Pass the List<UnitType>
            onSelected = { viewModel.updateFromUnit(it) }
        )

        DropdownMenuBox(
            label = "To Unit",
            selected = state.toUnit,
            options = unitsToDisplay, // Pass the List<UnitType>
            onSelected = { viewModel.updateToUnit(it) }
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = { viewModel.performConversion() }) {
            Text("Convert")
        }

        Spacer(Modifier.height(16.dp))

        Text("Result: ${state.result}")
    }
}

@Composable
fun DropdownMenuBox(
    label: String,
    selected: UnitType,
    options: List<UnitType>, // Changed from List<String>
    onSelected: (UnitType) -> Unit // Callback now directly gives UnitType
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Text(label)
        Button(onClick = { expanded = true }) {
            Text(selected.label) // Display the label of the selected UnitType
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { unitTypeOption -> // Iterate over List<UnitType>
                DropdownMenuItem(
                    text = { Text(unitTypeOption.label) }, // Display the label
                    onClick = {
                        onSelected(unitTypeOption) // Pass back the selected UnitType object
                        expanded = false
                    }
                )
            }
        }
    }
}