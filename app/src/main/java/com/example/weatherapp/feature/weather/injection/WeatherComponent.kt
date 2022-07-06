package com.example.weatherapp.feature.weather.injection

import com.example.weatherapp.feature.weather.view.WeatherViewImpl
import com.example.weatherapp.di.AppComponent
import com.example.weatherapp.scope.PerScreen
import dagger.Component

@PerScreen
@Component(modules = [WeatherModule::class],
    dependencies = [AppComponent::class])
interface WeatherComponent {
    fun inject(view: WeatherViewImpl)
}