package com.example.weatherapp.feature.weather.injection

import com.example.data.impl.weather.WeatherMapper
import com.example.data.impl.weather.WeatherRepositoryImpl
import com.example.data.impl.weather.WeatherService
import com.example.domain.usecases.weather.GetWeatherInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

//Expected: FragmentComponent ??
@InstallIn(SingletonComponent::class)
@Module
class WeatherModule {

    @Provides
//    @FragmentScoped
    fun provideWeatherMapper() = WeatherMapper()

    @Provides
//    @FragmentScoped
    fun provideService(retrofit: Retrofit): WeatherService =
        retrofit.create(WeatherService::class.java)

    @Provides
//    @FragmentScoped
    fun provideRepository(
        weatherService: WeatherService,
        weatherMapper: WeatherMapper
    ): WeatherRepositoryImpl {
        return WeatherRepositoryImpl(weatherService, weatherMapper)
    }

    //Use Case
    @Provides
//    @FragmentScoped
    fun provideGetWeatherInfoUseCase(repository: WeatherRepositoryImpl) = GetWeatherInfoUseCase(repository)
}