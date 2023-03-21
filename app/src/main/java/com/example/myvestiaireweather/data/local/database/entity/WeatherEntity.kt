package com.example.myvestiaireweather.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myvestiaireweather.data.remote.dto.City
import com.example.myvestiaireweather.domain.model.WeatherData

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey val id: Int? = null,
    val clouds: Int = 0,
    val deg: Int = 0,
    val dt: Int = 0,
    val gust: Double = 0.0,
    val humidity: Int = 0,
    val pop: Double = 0.0,
    val pressure: Int = 0,
    val rain: Double = 0.0,
    val speed: Double = 0.0,
    val sunrise: Int = 0,
    val sunset: Int = 0

)
fun WeatherEntity.toWeatherData(): WeatherData = WeatherData(
    clouds = clouds,
    deg = deg,
    dt = dt,
    gust = gust,
    humidity = humidity,
    pop = pop,
    pressure = pressure,
    rain = rain,
    speed = speed,
    sunset = sunset,
    sunrise = sunrise
)
