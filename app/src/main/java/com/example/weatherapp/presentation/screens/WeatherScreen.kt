package com.example.weatherapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherapp.presentation.CustomScreens
import com.example.weatherapp.presentation.components.weather.WeatherBody
import com.example.weatherapp.presentation.components.weather.WeatherContent
import com.example.weatherapp.presentation.components.weather.WeatherSecondaryContainer
import com.example.weatherapp.presentation.components.weather.WeatherTitle
import com.example.weatherapp.presentation.ui.theme.WeatherAppTheme
import com.example.weatherapp.presentation.viewmodel.WeatherViewmodel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(
    navController: NavController,
    viewModel: WeatherViewmodel = hiltViewModel<WeatherViewmodel>(),
) {
    val state = viewModel.state.value
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Refresh, contentDescription = "Refresh content" )
                    }
                    IconButton(onClick = {
                        navController.navigate(CustomScreens.RegionSearchScreen.route)
                    }) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search regions" )
                    }
                }
            )
        }
    ){
        Box(Modifier
            .fillMaxSize()
            .padding(it)
            .padding(24.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .shadow(
                elevation = 10.dp,
                spotColor = Color.White
            )
            .background(color = Color.DarkGray)
        ){
                if(state.isLoading){
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                } else if (state.error.isNotBlank()){
                    Text("Erro encontrado. Erro: ${state.error}", Modifier.align(Alignment.Center))
                } else if(state.weather!=null){
                    WeatherContent(weather = state.weather, modifier =
                    Modifier.fillMaxSize().padding(top = 36.dp, bottom = 36.dp))
                } else{
                    Text("Nenhuma informação encontrada sobre o clima", Modifier.align(Alignment.Center))
                }
            }
    }

}



