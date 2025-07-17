package com.example.unitconverterkmp

enum class UnitType(val label: String, val factorToBase: Double) {
    METER("Meter", 1.0),
    KILOMETER("Kilometer", 1000.0),
    CENTIMETER("Centimeter", 0.01),
    MILE("Mile", 1609.34),
    YARD("Yard", 0.9144)
}
