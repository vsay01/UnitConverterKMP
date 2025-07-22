package com.example.unitconverterkmp

data class ConversionState(
    val inputValue: String = "",
    val fromUnit: UnitType = UnitType.entries.firstOrNull() ?: UnitType.METER, // Sensible default
    val toUnit: UnitType = UnitType.entries.getOrNull(1) ?: UnitType.FEET,   // Sensible default, different from 'from'
    val result: String = ""
)
