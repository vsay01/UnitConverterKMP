package com.example.unitconverterkmp.utils

import kotlin.math.pow
import kotlin.math.round

fun formatDouble(value: Double, decimals: Int = 4): String {
    val factor = 10.0.pow(decimals)
    val rounded = round(value * factor) / factor
    return rounded.toString()
}