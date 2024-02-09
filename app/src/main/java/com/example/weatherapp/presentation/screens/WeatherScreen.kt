package com.example.weatherapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherapp.presentation.components.weather.WeatherBody
import com.example.weatherapp.presentation.components.weather.WeatherSecondaryContainer
import com.example.weatherapp.presentation.components.weather.WeatherTitle
import com.example.weatherapp.presentation.ui.theme.WeatherAppTheme
import com.example.weatherapp.presentation.viewmodel.WeatherViewmodel


@Composable
fun WeatherScreen(
    navController: NavController,
    viewModel: WeatherViewmodel = hiltViewModel<WeatherViewmodel>(),
) {
    val state = viewModel.state.value
    Box(
        Modifier
            .fillMaxSize()){
        if(state.isLoading){
            Text("Loading", Modifier.align(Alignment.Center))
        } else if (state.error.isNotBlank()){
            Text("Erro encontrado. Erro: ${state.error}", Modifier.align(Alignment.Center))
        } else if(state.weather!=null){
            state.weather.let { weather ->
                Column(Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
        //                WeatherTitle(
        //                    cityName = weather.city,
        //                    stateName = weather.state,
        //                    countryName = weather.country
        //                )
        //                WeatherBody(
        //                    temperature = weather.temperature,
        //                    title = weather.title,
        //                    feelsLike = weather.feelsLike,
        //                    description = weather.description
        //                )
        //                WeatherSecondaryContainer(
        //                    wind = weather.windSpeed,
        //                    humidity = weather.humidity,
        //                    pressure = weather.pressure
        //                )
                    Text(text = weather.city)
                }
            }
        } else{
            Text("Nenhuma informação encontrada sobre o clima", Modifier.align(Alignment.Center))
        }
    }
}



