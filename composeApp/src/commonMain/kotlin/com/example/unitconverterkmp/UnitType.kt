package com.example.unitconverterkmp // Or your actual package

enum class UnitType(val label: String, val factorToBase: Double) {
    // Define a base unit first, e.g., Meters for length
    METER("Meter", 1.0),               // Base unit for length
    CENTIMETER("Centimeter", 0.01),    // 1 Centimeter = 0.01 Meters
    KILOMETER("Kilometer", 1000.0),    // 1 Kilometer = 1000 Meters

    // Imperial/US Customary Units for Length
    INCH("Inch", 0.0254),            // 1 Inch = 0.0254 Meters
    FEET("Feet", 0.3048),            // <<-- ADD THIS (or ensure it's spelled correctly if it exists)
    // 1 Foot = 0.3048 Meters
    YARD("Yard", 0.9144),            // 1 Yard = 0.9144 Meters
    MILE("Mile", 1609.34);          // 1 Mile = 1609.34 Meters

    // You could add other categories like Mass, Temperature here,
    // but then your ViewModel logic might need to handle categories
    // if you don't want to mix, e.g., Meters with Kilograms in the same dropdowns.
}
