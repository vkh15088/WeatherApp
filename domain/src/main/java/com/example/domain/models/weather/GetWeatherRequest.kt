package com.example.domain.models.weather

class GetWeatherRequest {
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    var units: String = ""
    var appId: String = ""
}