package com.example.weatherapp.presentation

sealed class CustomScreens (val route:String) {
    object RegionSearchScreen : CustomScreens("/region_search_screen")
    object WeatherScreen : CustomScreens("/weather_screen")
}