package com.example.weatherapp.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import com.example.weatherapp.R
import com.example.weatherapp.feature.weather.view.WeatherViewImpl
import com.example.weatherapp.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        setRootView(WeatherViewImpl())
    }

    override fun layout(): Int {
        return R.layout.activity_main
    }

    @SuppressLint("WrongViewCast")
    override fun rootContainerView(): ViewGroup {
        return window.decorView.findViewById(R.id.weather_controller)
    }

}