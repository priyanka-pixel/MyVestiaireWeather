package com.example.myvestiaireweather.domain.model

import com.example.myvestiaireweather.data.remote.dto.City
import com.example.myvestiaireweather.data.remote.dto.FeelsLike
import com.example.myvestiaireweather.data.remote.dto.Temp
import com.example.myvestiaireweather.data.remote.dto.Weather

data class WeatherData(
    val weather: List<Weather> = listOf(Weather()),
    val clouds: Int = 0,
    val deg: Int = 0,
    val dt: Int = 0,
    val feels_like: FeelsLike = FeelsLike(),
    val gust: Double = 0.0,
    val humidity: Int = 0,
    val pop: Double = 0.0,
    val pressure: Int = 0,
    val rain: Double = 0.0,
    val speed: Double = 0.0,
    val sunrise: Int = 0,
    val sunset: Int = 0,
    val temp: Temp = Temp()
    )
val city: City = City()

