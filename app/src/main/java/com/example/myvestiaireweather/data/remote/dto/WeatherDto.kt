package com.example.myvestiaireweather.data.remote.dto

data class WeatherDto(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<WeatherList>,
    val message: Double
)
