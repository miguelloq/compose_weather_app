package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.model.RegionModel

interface IRegionRepository {
    suspend fun getRegionInformation(city:String): List<RegionModel>
}