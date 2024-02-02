package com.example.weatherapp.presentation.viewmodel

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.weatherapp.core.Constants
import com.example.weatherapp.core.Resource
import com.example.weatherapp.data.model.RegionModel
import com.example.weatherapp.domain.usecase.GetWeatherInformationUseCase
import com.example.weatherapp.presentation.state.RegionState
import com.example.weatherapp.presentation.state.WeatherState
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class WeatherViewmodel @Inject constructor(
    private val getWeatherInformationUseCase: GetWeatherInformationUseCase,
    private val savedStateHandle:SavedStateHandle
): ViewModel(){

    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state

    init{
        savedStateHandle.get<RegionModel>(Constants.PARAM_REGION_ID)?.let {
            getWeatherInformation(it)
        }
    }


    private fun getWeatherInformation(regionModel: RegionModel){
        getWeatherInformationUseCase(regionModel).onEach {result ->
            when(result){
                is Resource.Success->{_state.value = WeatherState(weather = result.data)}
                is Resource.Error -> {
                    _state.value = WeatherState(error = result.message ?:
                    "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {_state.value = WeatherState(isLoading = true)}
            }
        }
    }
}