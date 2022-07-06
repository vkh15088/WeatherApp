package com.example.data.responses.weather

import com.google.gson.annotations.SerializedName

class MainResponse {
    @SerializedName("temp")
    var temp: String = "°C"
        get() = "$field°C"
}
