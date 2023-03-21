package com.example.myvestiaireweather.presentation.detail.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myvestiaireweather.domain.repository.WeatherRepository
import com.example.myvestiaireweather.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository

) : ViewModel() {
    private val _uiState = MutableStateFlow(WeatherUiState())
    val state: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    init {
        getWeatherData()
    }
    fun getWeatherData() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getWeatherListings()
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let { listings ->
                                _uiState.update { it.copy(weathers = listings) }
                            }
                            _uiState.value = _uiState.value.copy()
                        }
                        is Resource.Error -> {
                            _uiState.value = _uiState.value.copy(error = "Error message")
                        }
                        is Resource.Loading -> {
                            _uiState.value = _uiState.value.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }
}