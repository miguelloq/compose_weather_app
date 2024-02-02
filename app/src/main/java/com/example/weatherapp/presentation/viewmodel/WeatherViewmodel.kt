package com.example.weatherapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.model.RegionModel
import com.example.weatherapp.domain.usecase.GetWeatherInformationUseCase
import com.example.weatherapp.presentation.state.WeatherState
import javax.inject.Inject

class WeatherViewmodel @Inject constructor(
    private val getWeatherInformation: GetWeatherInformationUseCase,
    private val savedStateHandle:SavedStateHandle
): ViewModel(){

    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state

    init{
        savedStateHandle.get<>()
    }

    private fun getWeatherInformation(regionModel: RegionModel){
        getWeatherInformation(regionModel)
    }
}