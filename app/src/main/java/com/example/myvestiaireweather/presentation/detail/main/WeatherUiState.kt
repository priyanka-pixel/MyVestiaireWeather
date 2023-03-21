package com.example.myvestiaireweather.presentation.detail.main

import com.example.myvestiaireweather.domain.model.WeatherData

data class WeatherUiState(
    val weathers: List<WeatherData> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)

