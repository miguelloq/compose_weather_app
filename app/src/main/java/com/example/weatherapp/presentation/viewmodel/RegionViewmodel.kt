package com.example.weatherapp.presentation.viewmodel

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.weatherapp.core.Constants
import com.example.weatherapp.core.Resource
import com.example.weatherapp.domain.usecase.GetRegionsInformationUseCase
import com.example.weatherapp.presentation.state.RegionState
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class RegionViewmodel @Inject constructor(
    private val getRegionInformationUseCase: GetRegionsInformationUseCase,
    private val savedStateHandle: SavedStateHandle,
) :ViewModel(){

    private val _state = mutableStateOf(RegionState())
    val state: State<RegionState> = _state


    init {
        savedStateHandle.get<String>(Constants.PARAM_CITY_ID)?.let {getRegionInformation(it) }
    }

    private fun getRegionInformation(city:String){
        getRegionInformationUseCase(city).onEach {result ->
            when(result){
               is Resource.Success->{
                   _state.value = RegionState(
                       regions = result.data ?: emptyList()
                   )
               }
                is Resource.Error -> {
                    _state.value = RegionState(error = result.message ?:
                    "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {_state.value = RegionState(isLoading = true)}
            }
        }
    }
}