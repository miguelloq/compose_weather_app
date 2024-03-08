package com.example.weatherapp.presentation.components.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weatherapp.domain.model.WeatherModel

@Composable
fun WeatherContent(weather:WeatherModel, modifier: Modifier = Modifier) {
    Column(
        modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        WeatherTitle(
            cityName = weather.city,
            stateName = weather.state,
            countryName = weather.country
        )
        WeatherBody(
            temperature = weather.temperature,
            title = weather.title,
            feelsLike = weather.feelsLike,
            description = weather.description
        )
        WeatherSecondaryContainer(
            wind = weather.windSpeed,
            humidity = weather.humidity,
            pressure = weather.pressure
        )
    }
}
