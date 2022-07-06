package com.example.domain.usecases.weather

import com.example.domain.base.BaseUseCase
import com.example.domain.models.weather.GetWeatherRequest
import com.example.domain.models.weather.PostInfo
import com.example.domain.repository.weather.WeatherRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetWeatherInfoUseCase @Inject constructor(private var repository: WeatherRepository)
    : BaseUseCase<GetWeatherRequest, PostInfo> {

    override fun execute(request: GetWeatherRequest): Observable<PostInfo> {
        return repository.getWeatherAPI(request)
    }


}