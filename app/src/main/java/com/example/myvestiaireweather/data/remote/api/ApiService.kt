package com.example.myvestiaireweather.data.remote.api

import com.example.myvestiaireweather.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(END_POINT)
    suspend fun getWeatherDto(
        @Query("APPID") APPID: String = "648a3aac37935e5b45e09727df728ac2",
        @Query("q") q: String = "Paris",
        @Query("mode") mode: String = "json",
        @Query("units") units: String = "metric",
        @Query("cnt") cnt: String = "16"
    ): WeatherDto

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"
        const val END_POINT = "data/2.5/forecast/daily"
    }
}
//APPID=648a3aac37935e5b45e09727df728ac2