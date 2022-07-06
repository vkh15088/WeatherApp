package com.example.data.impl.weather

import com.example.domain.models.weather.GetWeatherRequest
import com.example.domain.models.weather.PostInfo
import com.example.domain.repository.weather.WeatherRepository
import io.reactivex.Observable

class WeatherRepositoryImpl constructor(
    private val weatherService: WeatherService,
    private val weatherMapper: WeatherMapper
) : WeatherRepository {

    override fun getWeatherAPI(request: GetWeatherRequest): Observable<PostInfo> {
        //Map sẽ chuyển đổi các item được phát ra bởi 1 Observable bằng cách áp dụng mỗi hàm cho mỗi item, dễ hiểu hơn thì nó dùng để chuyển đối 1 item thành 1 item khác.
        return weatherService.getWeatherInfo(request.latitude, request.longitude, request.units, request.appId)
            .map { weatherMapper.fromResponseToInfo(it) }
    }
}