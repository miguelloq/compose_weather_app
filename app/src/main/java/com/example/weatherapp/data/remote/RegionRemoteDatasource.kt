package com.example.weatherapp.data.remote

import com.example.weatherapp.core.GitIgnoreConstants
import com.example.weatherapp.data.remote.dto.region.RegionDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RegionRemoteDatasource {

    @GET("/geo/1.0/direct?q={cityName}&limit={limitNumber}&appid={apiKey}")
    suspend fun getRegionInformation(
        @Path("cityName") city:String,
        @Path("limitNumber") limitNumber:Int = 5,
        @Path("apiKey") apiKey:String = GitIgnoreConstants.APIKEY
    ) : RegionDto
}