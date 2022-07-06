package com.example.weatherapp.feature.weather.injection

import com.example.data.impl.weather.WeatherMapper
import com.example.data.impl.weather.WeatherRepositoryImpl
import com.example.data.impl.weather.WeatherService
import com.example.domain.usecases.weather.GetWeatherInfoUseCase
import com.example.weatherapp.scope.PerScreen
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class WeatherModule {

    @Provides
    @PerScreen
    fun provideWeatherMapper() = WeatherMapper()

    @Provides
    @PerScreen
    fun provideService(retrofit: Retrofit): WeatherService =
        retrofit.create(WeatherService::class.java)

    @Provides
    @PerScreen
    fun provideRepository(
        weatherService: WeatherService,
        weatherMapper: WeatherMapper
    ): WeatherRepositoryImpl {
        return WeatherRepositoryImpl(weatherService, weatherMapper)
    }

    //Use Case
    @Provides
    @PerScreen
    fun provideGetWeatherInfoUseCase(repository: WeatherRepositoryImpl) = GetWeatherInfoUseCase(repository)
}