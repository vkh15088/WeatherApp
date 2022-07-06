package com.example.weatherapp.application.app

import android.app.Application
import com.example.weatherapp.di.AppComponent
import com.example.weatherapp.di.DaggerAppComponent
import com.example.weatherapp.di.NetworkModule

class WeatherApp: Application() {

    companion object{
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .application(this)
            .netModule(NetworkModule())
            .build()
    }
}