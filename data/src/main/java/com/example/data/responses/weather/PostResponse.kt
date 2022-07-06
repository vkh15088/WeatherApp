package com.example.data.responses.weather

import com.google.gson.annotations.SerializedName

class PostResponse {
    @SerializedName("weather")
    var mWeatherList: ArrayList<WeatherResponse> = ArrayList()

    @SerializedName("main")
    var mMain: MainResponse = MainResponse()

    @SerializedName("name")
    var mCountryName: String = ""

}
