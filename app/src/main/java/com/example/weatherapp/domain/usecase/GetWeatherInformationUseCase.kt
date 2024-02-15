package com.example.weatherapp.domain.usecase

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.weatherapp.core.Resource
import com.example.weatherapp.domain.model.RegionModel
import com.example.weatherapp.domain.model.WeatherModel
import com.example.weatherapp.domain.repository.IRegionRepository
import com.example.weatherapp.domain.repository.IWeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

import javax.inject.Inject

class GetWeatherInformationUseCase @Inject constructor(
    private val repository: IWeatherRepository
){

    operator fun invoke(region: RegionModel): Flow<Resource<WeatherModel>> = flow{
        try {
            emit(Resource.Loading<WeatherModel>())
            val weather = repository.getWeatherInformation(region)
            emit(Resource.Success<WeatherModel>(weather))
        }catch (e:IOException){
            emit(Resource.Error<WeatherModel>("Ba2"))
        }catch (e:Exception){
            emit(Resource.Error<WeatherModel>("Erro desconhecido poggers"))
        }
    }
}