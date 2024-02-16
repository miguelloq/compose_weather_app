package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.domain.repository.IWeatherRepository
import com.example.weatherapp.domain.usecase.GetWeatherInformationUseCase
import com.example.weatherapp.presentation.CustomScreens
import com.example.weatherapp.presentation.screens.RegionSearchScreen
import com.example.weatherapp.presentation.screens.WeatherScreen
import com.example.weatherapp.presentation.ui.theme.WeatherAppTheme
import com.example.weatherapp.presentation.viewmodel.WeatherViewmodel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeatherAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = CustomScreens.WeatherScreen.route,
                    ){
                        composable(
                            route = CustomScreens.WeatherScreen.route
                        ){
                            WeatherScreen(navController = navController)
                        }
                        composable(
                            route = CustomScreens.RegionSearchScreen.route
                        ){
                            RegionSearchScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

