package com.example.weatherapp.data.remote.dto.region

import com.example.weatherapp.data.model.RegionModel

class RegionDto : ArrayList<RegionDtoItem>(){
    fun toRegionModelList():List<RegionModel>{

        fun regionDtoItemToRegionModel(dtoItem:RegionDtoItem):RegionModel{
            return RegionModel(
                city = dtoItem.name,
                state = dtoItem.state,
                country = dtoItem.country,
                latitude = dtoItem.lat,
                longitude = dtoItem.lon
            )
        }

        return this.map {regionDtoItemToRegionModel(it)}
    }
}