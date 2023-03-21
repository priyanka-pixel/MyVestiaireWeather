package com.example.myvestiaireweather.data.local.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myvestiaireweather.data.local.database.entity.WeatherEntity


@Database(
    entities = [WeatherEntity::class],
    version = 5,
    exportSchema = false
)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}