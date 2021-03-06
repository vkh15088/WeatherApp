package com.example.weatherapp.feature.weather.view

import com.example.domain.models.weather.PostInfo

interface WeatherView {
    fun getAPISuccessful(post: PostInfo)
    fun getAPIFail(message: String)
    fun displayData(post: PostInfo)
    fun getWeatherImage(mIcon: String)
    fun getAPI()
    fun injectDependencies()
}
