package com.example.myvestiaireweather.domain.repository

import com.example.myvestiaireweather.domain.model.WeatherData
import com.example.myvestiaireweather.util.Resource
import kotlinx.coroutines.flow.Flow


interface WeatherRepository {
    suspend fun getWeatherListings(): Flow<Resource<List<WeatherData>>>
}