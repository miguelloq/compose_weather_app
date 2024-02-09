package com.example.weatherapp.presentation.components.weather

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WeatherSecondaryContainer(
    wind:Double,
    humidity:Int,
    pressure:Int,
    modifier: Modifier = Modifier,
) {
    Text(text = "WeatherSecondaryContainer")
}

@Preview
@Composable
fun WeatherSecondaryContainer() {
    WeatherSecondaryContainer(wind = 2.57, humidity = 66, pressure = 1015)
}