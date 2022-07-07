package com.example.weatherapp.feature.weather.injection

import com.example.data.impl.weather.WeatherMapper
import com.example.data.impl.weather.WeatherRepositoryImpl
import com.example.data.impl.weather.WeatherService
import com.example.domain.usecases.weather.GetWeatherInfoUseCase
import com.funnydevs.hilt_conductor.ControllerComponent
import com.funnydevs.hilt_conductor.annotations.ControllerScoped
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit

@InstallIn(ControllerComponent::class)
@Module
class WeatherModule {

    @Provides
    @ControllerScoped
    fun provideWeatherMapper() = WeatherMapper()

    @Provides
    @ControllerScoped
    fun provideService(retrofit: Retrofit): WeatherService =
        retrofit.create(WeatherService::class.java)

    @Provides
    @ControllerScoped
    fun provideRepository(
        weatherService: WeatherService,
        weatherMapper: WeatherMapper
    ): WeatherRepositoryImpl {
        return WeatherRepositoryImpl(weatherService, weatherMapper)
    }

    //Use Case
    @Provides
    @ControllerScoped
    fun provideGetWeatherInfoUseCase(repository: WeatherRepositoryImpl) = GetWeatherInfoUseCase(repository)
}