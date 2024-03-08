package com.example.weatherapp.presentation.components.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WeatherSecondaryContainer(
    wind:Double,
    humidity:Int,
    pressure:Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = Color.Black),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
        ) {
       Column(horizontalAlignment = Alignment.CenterHorizontally) {
           Icon(imageVector = Icons.Filled.List, contentDescription = "Wind speed")
           Text(wind.toString())
       }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(imageVector = Icons.Filled.List, contentDescription = "Humidity")
            Text(humidity.toString())
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(imageVector = Icons.Filled.List, contentDescription = "Pressure value")
            Text(pressure.toString())
        }
    }
}

@Preview
@Composable
fun WeatherSecondaryContainer() {
    WeatherSecondaryContainer(wind = 2.57, humidity = 66, pressure = 1015)
}