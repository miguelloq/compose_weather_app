package com.example.weatherapp.domain.usecase

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.weatherapp.core.Resource
import com.example.weatherapp.data.model.RegionModel
import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.domain.repository.IWeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

import javax.inject.Inject

class GetWeatherInformationUseCase @Inject constructor(
    private val repository: IWeatherRepository
){

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(region: RegionModel): Flow<Resource<WeatherModel>> = flow{
        try {
            emit(Resource.Loading<WeatherModel>())
            val weather = repository.getWeatherInformation(region)
            emit(Resource.Success<WeatherModel>(weather))
        }catch (e:HttpException){
            emit(Resource.Error<WeatherModel>("Ba"))
        }catch (e:IOException){
            emit(Resource.Error<WeatherModel>("Ba2"))
        }
    }
}