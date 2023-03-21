package com.example.myvestiaireweather.di

import android.app.Application
import androidx.room.Room
import com.example.myvestiaireweather.data.local.database.room.WeatherDatabase
import com.example.myvestiaireweather.data.remote.api.ApiService
import com.example.myvestiaireweather.data.repository.WeatherRepoImpl
import com.example.myvestiaireweather.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .build()

    @Provides
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(ApiService.BASE_URL)
        .build()

    @Provides
    fun providesWeatherApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)


    @Provides
    fun providesDatabase(app: Application): WeatherDatabase {
        return Room.databaseBuilder(
            app,
            WeatherDatabase::class.java,
            "weather.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesRepository(
        apiService: ApiService,
        db: WeatherDatabase
    ): WeatherRepository {
        return WeatherRepoImpl(apiService, db)
    }
}
