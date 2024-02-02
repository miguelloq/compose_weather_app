package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.RegionModel
import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.data.remote.WeatherRemoteDatasource
import com.example.weatherapp.data.remote.dto.weather.WeatherDto
import com.example.weatherapp.domain.repository.IWeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val remoteDatasource:WeatherRemoteDatasource
) : IWeatherRepository{
    override suspend fun getWeatherInformation(region:RegionModel): WeatherModel {
        return remoteDatasource.getWeatherInformation(latitude = region.latitude, longitude = region.longitude).toWeatherModel(
            city = region.city,
            state = region.state,
            country = region.country,
        )
    }

}