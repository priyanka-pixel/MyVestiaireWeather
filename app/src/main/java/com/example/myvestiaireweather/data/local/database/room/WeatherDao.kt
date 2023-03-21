package com.example.myvestiaireweather.data.local.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myvestiaireweather.data.local.database.entity.WeatherEntity

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherList(weatherListingEntity: WeatherEntity)

    @Query("SELECT * FROM weather")
    suspend fun weatherTable(): List<WeatherEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetails(weatherListingEntity: WeatherEntity)

    @Query("SELECT * FROM weather WHERE id = :id")
    fun getWeather(id: Int): List<WeatherEntity>
}