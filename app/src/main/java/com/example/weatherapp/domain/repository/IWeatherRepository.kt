package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.model.RegionModel
import com.example.weatherapp.domain.model.WeatherModel
interface IWeatherRepository {
    suspend fun getWeatherInformation(region: RegionModel): WeatherModel
}