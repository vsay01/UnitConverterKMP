package com.example.unitconverterkmp // Assuming this is your package

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.math.round // For a simple formatting example

// Assuming UnitType.kt is in the same package or imported correctly
// enum class UnitType(val label: String, val factorToBase: Double) { ... }

class ConverterViewModel {

    // Expose the list of available UnitType objects directly from the enum
    val availableUnits: List<UnitType> = UnitType.entries.toList()

    private val _state = MutableStateFlow(
        ConversionState(
            // Ensure initial fromUnit and toUnit are valid and preferably different
            fromUnit = availableUnits.firstOrNull()
                ?: UnitType.METER, // Default to Meters if list is empty for some reason
            toUnit = availableUnits.getOrNull(1) ?: availableUnits.firstOrNull() ?: UnitType.FEET
        )
    )
    val state: StateFlow<ConversionState> = _state.asStateFlow()

    fun updateInput(value: String) {
        _state.update { it.copy(inputValue = value) }
        // Optionally, you can trigger conversion immediately on input change
        // if you remove the dedicated convert button:
        // performConversion()
    }

    fun updateFromUnit(unit: UnitType) {
        _state.update { it.copy(fromUnit = unit) }
        // Optionally trigger conversion if inputValue is not empty:
        // if (_state.value.inputValue.isNotBlank()) performConversion()
    }

    fun updateToUnit(unit: UnitType) {
        _state.update { it.copy(toUnit = unit) }
        // Optionally trigger conversion if inputValue is not empty:
        // if (_state.value.inputValue.isNotBlank()) performConversion()
    }

    fun performConversion() {
        val currentInput = _state.value.inputValue
        val from = _state.value.fromUnit
        val to = _state.value.toUnit

        val inputDouble = currentInput.toDoubleOrNull()

        if (inputDouble == null) {
            _state.update { it.copy(result = "Invalid input") }
            return
        }

        // Core conversion logic using UnitType's factorToBase
        val valueInBaseUnit = inputDouble * from.factorToBase
        val convertedValue = valueInBaseUnit / to.factorToBase

        _state.update { it.copy(result = formatDoublePlaceholder(convertedValue, 4)) }
    }

    // Placeholder for your chosen formatting function (expect/actual or common)
    // Replace this with your actual implementation
    private fun formatDoublePlaceholder(value: Double, decimals: Int = 4): String {
        val multiplier = "1${"0".repeat(decimals)}".toDouble()
        val rounded = round(value * multiplier) / multiplier
        // This is a very basic way to format, you might want something more robust
        // to handle trailing zeros correctly for all cases, e.g., using expect/actual.
        return rounded.toString() // For now, just converting to string.
        // Consider String.format on JVM/Android via expect/actual for better control.
    }
}
