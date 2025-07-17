package com.example.unitconverterkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform