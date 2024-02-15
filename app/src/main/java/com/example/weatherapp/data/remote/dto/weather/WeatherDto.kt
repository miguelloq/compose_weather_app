package com.example.weatherapp.data.remote.dto.weather

import com.example.weatherapp.domain.model.WeatherModel

data class WeatherDto(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
){
    fun toWeatherModel(
        city:String,
        state:String,
        country:String
    ): WeatherModel {
       return WeatherModel(
           city =city,
           state =state,
           country =country,
           title =this.weather.first().main,
           description = this.weather.first().description,
           temperature = this.main.temp,
           feelsLike = this.main.feels_like,
           windSpeed = this.wind.speed,
           humidity = this.main.humidity,
           pressure = this.main.pressure
       )
    }
}