package com.example.unitconverterkmp

data class ConversionState(
    val inputValue: String = "",
    val fromUnit: UnitType = UnitType.METER,
    val toUnit: UnitType = UnitType.KILOMETER,
    val result: String = ""
)
