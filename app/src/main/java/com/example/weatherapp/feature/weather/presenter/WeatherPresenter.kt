package com.example.weatherapp.feature.weather.presenter

interface WeatherPresenter {
    fun onGetAPI(
        lat: Double,
        lon: Double,
        units: String
    )

}
