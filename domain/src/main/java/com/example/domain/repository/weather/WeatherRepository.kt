package com.example.domain.repository.weather

import com.example.domain.models.weather.GetWeatherRequest
import com.example.domain.models.weather.PostInfo
import io.reactivex.Observable

interface WeatherRepository {
    fun getWeatherAPI(request: GetWeatherRequest): Observable<PostInfo>
}