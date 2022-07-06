package com.example.data.responses.weather

import com.google.gson.annotations.SerializedName

class WeatherResponse {
    @SerializedName("icon")
    var mIcon: String = ""
        get() = "$field@2x.png"

    @SerializedName("main")
    var mMain: String = ""
}
