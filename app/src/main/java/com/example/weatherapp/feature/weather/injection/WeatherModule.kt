package com.example.weatherapp.feature.weather.injection

import com.example.data.impl.weather.WeatherMapper
import com.example.data.impl.weather.WeatherRepositoryImpl
import com.example.data.impl.weather.WeatherService
import com.example.domain.usecases.weather.GetWeatherInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Retrofit

@InstallIn(ActivityComponent::class)
@Module
class WeatherModule {

    @Provides
    @ActivityScoped
    fun provideWeatherMapper() = WeatherMapper()

    @Provides
    @ActivityScoped
    fun provideService(retrofit: Retrofit): WeatherService =
        retrofit.create(WeatherService::class.java)

    @Provides
    @ActivityScoped
    fun provideRepository(
        weatherService: WeatherService,
        weatherMapper: WeatherMapper
    ): WeatherRepositoryImpl {
        return WeatherRepositoryImpl(weatherService, weatherMapper)
    }

    //Use Case
    @Provides
    @ActivityScoped
    fun provideGetWeatherInfoUseCase(repository: WeatherRepositoryImpl) = GetWeatherInfoUseCase(repository)
}