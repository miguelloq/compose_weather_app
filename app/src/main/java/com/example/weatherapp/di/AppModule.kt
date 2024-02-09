package com.example.weatherapp.di

import com.example.weatherapp.core.Constants
import com.example.weatherapp.data.remote.RegionRemoteDatasource
import com.example.weatherapp.data.remote.WeatherRemoteDatasource
import com.example.weatherapp.data.repository.test.RegionRepositoryTest
import com.example.weatherapp.data.repository.test.WeatherRepositoryTest
import com.example.weatherapp.domain.repository.IRegionRepository
import com.example.weatherapp.domain.repository.IWeatherRepository
import com.example.weatherapp.domain.usecase.GetWeatherInformationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun provideWeatherRemoteDatasource():WeatherRemoteDatasource{
        return Retrofit.Builder()
            .baseUrl(Constants.OPEN_WEATHER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherRemoteDatasource::class.java)
    }

    @Provides
    @Singleton
    fun provideRegionRemoteDatasource(): RegionRemoteDatasource {
        return Retrofit.Builder()
            .baseUrl(Constants.OPEN_WEATHER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RegionRemoteDatasource::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(remoteDatasource: WeatherRemoteDatasource):IWeatherRepository{
        return WeatherRepositoryTest(remoteDatasource)
    }

    @Provides
    @Singleton
    fun provideRegionRepository(remoteDatasource: RegionRemoteDatasource): IRegionRepository {
        return RegionRepositoryTest(remoteDatasource)
    }
}