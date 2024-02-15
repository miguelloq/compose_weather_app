package com.example.weatherapp.presentation.state

import com.example.weatherapp.domain.model.WeatherModel

data class WeatherState(
    val isLoading:Boolean=false,
    val weather: WeatherModel? = null,
    val error:String = ""
)