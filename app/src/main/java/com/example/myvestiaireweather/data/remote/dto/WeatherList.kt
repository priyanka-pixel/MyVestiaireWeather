package com.example.myvestiaireweather.data.remote.dto

import com.example.myvestiaireweather.domain.model.WeatherData

data class WeatherList(
    val clouds: Int,
    val deg: Int,
    val dt: Int,
    val feels_like: FeelsLike,
    val gust: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double,
    val speed: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: Temp,
    val weather: List<Weather>
)
fun WeatherList.toWeatherData(): WeatherData = WeatherData(
    clouds = clouds,
    deg = deg,
    dt = dt,
    feels_like = feels_like,
    gust = gust,
    humidity = humidity,
    pop = pop,
    pressure = pressure,
    rain = rain,
    speed = speed,
    sunrise = sunrise,
    sunset = sunset,
    temp = temp,
    weather = weather,


)