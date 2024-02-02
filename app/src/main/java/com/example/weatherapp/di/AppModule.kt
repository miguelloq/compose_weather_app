package com.example.weatherapp.di

import com.example.weatherapp.core.Constants
import com.example.weatherapp.data.remote.WeatherRemoteDatasource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun provideWeatherRemoteDatasource():WeatherRemoteDatasource{
        Retrofit.Builder()
            .baseUrl(Constants.OPEN_WEATHER_BASE_URL)
            .addConverterFactory(GsonConve)
    }
}