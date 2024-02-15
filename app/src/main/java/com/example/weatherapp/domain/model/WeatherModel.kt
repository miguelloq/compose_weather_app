package com.example.weatherapp.domain.model

class WeatherModel(
    val city:String,
    val state:String,
    val country:String,
    val title:String,
    val description:String,
    val temperature:Double,
    val feelsLike:Double,
    val windSpeed:Double,
    val humidity: Int,
    val pressure: Int,
) {
}