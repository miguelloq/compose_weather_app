package com.example.weatherapp.presentation.components.weather

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WeatherTitle(
    cityName:String,
    stateName:String,
    countryName:String,
    modifier: Modifier = Modifier,
) {
    Column(modifier
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = cityName)
    }
}

@Preview()
@Composable
fun WeatherTitlePrev() {
    WeatherTitle(cityName = "Fortal", stateName = "Hell" , countryName = "BR" )
}