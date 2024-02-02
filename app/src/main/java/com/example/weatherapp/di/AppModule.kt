package com.example.weatherapp.di

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
    fun providePaprikaApi():WeatherRemoteDatasource{
        //Refrofit.bu
    }
}