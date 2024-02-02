package com.example.weatherapp.data.remote

import com.example.weatherapp.core.GitIgnoreConstants
import com.example.weatherapp.data.remote.dto.weather.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherRemoteDatasource {
    @GET("/data/2.5/weather?lat={lat}&lon={lon}&appid={apiKey}&units=metric")
    suspend fun getWeatherInformation(
        @Path("lat") latitude:Double,
        @Path("lon") longitude:Double,
        @Path("apiKey") apiKey:String = GitIgnoreConstants.APIKEY,
    ): WeatherDto
}