package com.example.weatherapp.data.remote.dto.region

data class RegionDtoItem(
    val country: String,
    val lat: Double,
    val local_names: LocalNames,
    val lon: Double,
    val name: String,
    val state: String
)