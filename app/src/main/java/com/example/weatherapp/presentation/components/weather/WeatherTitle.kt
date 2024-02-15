package com.example.weatherapp.presentation.components.weather

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WeatherTitle(
    cityName:String,
    stateName:String,
    countryName:String,
    modifier: Modifier = Modifier,
) {
    Column(
    ) {
        Text(
            text = cityName,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
            )
        Text(
            text = "$stateName,$countryName",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Preview()
@Composable
fun WeatherTitlePrev() {
    WeatherTitle(cityName = "Fortal", stateName = "Hell" , countryName = "BR" )
}