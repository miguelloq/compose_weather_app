package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.model.RegionModel
import com.example.weatherapp.data.model.WeatherModel
interface IWeatherRepository {
    suspend fun getWeatherInformation(region:RegionModel): WeatherModel
}