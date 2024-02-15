package com.example.weatherapp.data.repository.test

import com.example.weatherapp.domain.model.RegionModel
import com.example.weatherapp.data.remote.RegionRemoteDatasource
import com.example.weatherapp.domain.repository.IRegionRepository
import javax.inject.Inject

class RegionRepositoryTest @Inject constructor(
    private val remoteDatasource: RegionRemoteDatasource
) :IRegionRepository{
    override suspend fun getRegionInformation(city: String): List<RegionModel> {
        return listOf<RegionModel>(
            RegionModel(
                city="Fortal",
                state = "Hell",
                country = "BR",
                latitude = 44.34,
                longitude = 10.99
            )
        )
    }
}