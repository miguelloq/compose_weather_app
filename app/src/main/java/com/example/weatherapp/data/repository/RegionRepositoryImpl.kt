package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.RegionModel
import com.example.weatherapp.data.remote.RegionRemoteDatasource
import com.example.weatherapp.domain.repository.IRegionRepository
import javax.inject.Inject

class RegionRepositoryImpl @Inject constructor(
    private val remoteDatasource: RegionRemoteDatasource
):IRegionRepository{
    override suspend fun getRegionInformation(city: String): List<RegionModel> {
        return remoteDatasource.getRegionInformation(city).toRegionModelList()
    }
}