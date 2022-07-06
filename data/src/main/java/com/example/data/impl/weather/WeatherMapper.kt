package com.example.data.impl.weather

import com.example.data.responses.weather.PostResponse
import com.example.domain.base.BaseModelMapper
import com.example.domain.models.weather.PostInfo
import com.example.domain.models.weather.WeatherInfo

class WeatherMapper : BaseModelMapper<PostResponse, PostInfo> {
    override fun fromResponseToInfo(from: PostResponse): PostInfo {

        val postInfo = PostInfo()

//        if (from.mWeatherList != null){
            for (item in from.mWeatherList){
                val weatherInfo = WeatherInfo()
                weatherInfo.mIcon = item.mIcon
                weatherInfo.mMain = item.mMain
                postInfo.mWeatherList.add(weatherInfo)
            }
//        }
        postInfo.mMain.temp = from.mMain.temp
        postInfo.mCountryName = from.mCountryName
        return postInfo
    }
}