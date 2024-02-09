package com.example.weatherapp.presentation.components.weather

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WeatherBody(
    temperature:Double,
    title:String,
    feelsLike:Double,
    description:String,
    modifier: Modifier = Modifier,
) {
    Text(text = "WeatherBody $title")
}

@Preview
@Composable
fun WeatherBodyPrev() {
    WeatherBody(temperature = 30.0, title = "Clouds", feelsLike = 60.24, description = "Few Clouds")
}