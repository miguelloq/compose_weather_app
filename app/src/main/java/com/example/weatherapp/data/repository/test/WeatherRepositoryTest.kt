package com.example.weatherapp.data.repository.test

import com.example.weatherapp.domain.model.RegionModel
import com.example.weatherapp.domain.model.WeatherModel
import com.example.weatherapp.data.remote.WeatherRemoteDatasource
import com.example.weatherapp.domain.repository.IWeatherRepository
import javax.inject.Inject

class WeatherRepositoryTest @Inject constructor(
    private val remoteDatasource: WeatherRemoteDatasource
):IWeatherRepository {
    override suspend fun getWeatherInformation(region: RegionModel): WeatherModel {
        return WeatherModel(
            city = "Fortal",
            state = "Hell",
            country = "BR",
            title = "HOT",
            description = "HooooooT",
            temperature = 69.24,
            feelsLike = 420.00,
            windSpeed = 6.9,
            humidity = 2,
            pressure = 4
        )
    }
}