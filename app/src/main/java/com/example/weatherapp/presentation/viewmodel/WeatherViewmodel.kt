package com.example.weatherapp.presentation.viewmodel

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.core.Constants
import com.example.weatherapp.core.Resource
import com.example.weatherapp.domain.model.RegionModel
import com.example.weatherapp.domain.usecase.GetWeatherInformationUseCase
import com.example.weatherapp.presentation.state.RegionState
import com.example.weatherapp.presentation.state.WeatherState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeatherViewmodel @Inject constructor(
    private val getWeatherInformationUseCase: GetWeatherInformationUseCase,
    private val savedStateHandle:SavedStateHandle
): ViewModel(){

    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state

    init{
        val tes= RegionModel("a","b","c",1.0,1.0)
//        savedStateHandle.get<RegionModel>(Constants.PARAM_REGION_ID)?.let {
//            getWeatherInformation(it)
//        }
        getWeatherInformation(tes)
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
        }.launchIn(viewModelScope)
    }
}