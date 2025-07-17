package com.example.unitconverterkmp

import com.example.unitconverterkmp.utils.formatDouble
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ConverterViewModel {
    private val _state = MutableStateFlow(ConversionState())
    val state = _state.asStateFlow()

    fun onInputChange(value: String) {
        _state.value = _state.value.copy(inputValue = value)
        calculate()
    }

    fun onFromUnitChange(unit: UnitType) {
        _state.value = _state.value.copy(fromUnit = unit)
        calculate()
    }

    fun onToUnitChange(unit: UnitType) {
        _state.value = _state.value.copy(toUnit = unit)
        calculate()
    }

    private fun calculate() {
        val input = _state.value.inputValue.toDoubleOrNull()
        val from = _state.value.fromUnit
        val to = _state.value.toUnit

        val result = if (input != null) {
            val base = input * from.factorToBase
            val converted = base / to.factorToBase
            formatDouble(converted, 4)
        } else {
            ""
        }

        _state.value = _state.value.copy(result = result)
    }
}
