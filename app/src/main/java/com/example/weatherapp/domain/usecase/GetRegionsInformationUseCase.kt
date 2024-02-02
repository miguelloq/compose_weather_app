package com.example.weatherapp.domain.usecase

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.weatherapp.core.Resource
import com.example.weatherapp.data.model.RegionModel
import com.example.weatherapp.domain.repository.IRegionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetRegionsInformationUseCase @Inject constructor(
    private  val repository: IRegionRepository
) {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(city:String): Flow<Resource<List<RegionModel>>> = flow{
        try {
            emit(Resource.Loading<List<RegionModel>>())
            val regions = repository.getRegionInformation(city)
            emit(Resource.Success<List<RegionModel>>(regions))
        }catch (e:HttpException){
            emit(Resource.Error<List<RegionModel>>("Aa"))
        }catch (e:IOException){
            emit(Resource.Error<List<RegionModel>>("Aa2"))
        }
    }
}