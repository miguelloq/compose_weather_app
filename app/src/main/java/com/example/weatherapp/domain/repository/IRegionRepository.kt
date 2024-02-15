package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.model.RegionModel

interface IRegionRepository {
    suspend fun getRegionInformation(city:String): List<RegionModel>
}