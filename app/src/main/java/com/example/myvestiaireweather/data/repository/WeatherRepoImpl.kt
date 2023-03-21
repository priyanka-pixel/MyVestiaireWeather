package com.example.myvestiaireweather.data.repository


import com.example.myvestiaireweather.data.local.database.room.WeatherDatabase
import com.example.myvestiaireweather.data.remote.api.ApiService
import com.example.myvestiaireweather.data.remote.dto.toWeatherData
import com.example.myvestiaireweather.domain.model.WeatherData
import com.example.myvestiaireweather.domain.repository.WeatherRepository
import com.example.myvestiaireweather.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherRepoImpl @Inject constructor(
    private val apiService: ApiService,
    db: WeatherDatabase
) : WeatherRepository {
    override suspend fun getWeatherListings(): Flow<Resource<List<WeatherData>>> {
        return flow {
            emit(Resource.Loading())
            val weatherData = try {
                apiService.getWeatherDto().list
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null // flow{null}
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null // flow{null}
            }
            weatherData?.let { listings ->
                emit(Resource.Success(
                    data = listings.map { it.toWeatherData() }
                ))
            }
        }
    }

}