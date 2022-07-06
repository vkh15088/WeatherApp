package com.example.data.impl.weather

import com.example.data.constants.ApiConstants
import com.example.data.responses.weather.PostResponse
import com.example.domain.models.weather.PostInfo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET(ApiConstants.GET_WEATHER_INFO)
    fun getWeatherInfo(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("units") units: String,
        @Query("appid") appId: String
    ): Observable<PostResponse>
}