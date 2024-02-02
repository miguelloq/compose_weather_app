package com.example.weatherapp.presentation.state

import com.example.weatherapp.data.model.RegionModel

data class RegionState(
    val isLoading:Boolean = false,
    val regions:List<RegionModel> = emptyList(),
    val error:String = ""
)