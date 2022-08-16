package com.example.weatherapp.feature.weather.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.models.weather.GetWeatherRequest
import com.example.domain.models.weather.PostInfo
import com.example.domain.usecases.weather.GetWeatherInfoUseCase
import com.example.weatherapp.BuildConfig
import com.example.weatherapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
open class WeatherViewModel @Inject constructor(private val getWeatherInfoUseCase: GetWeatherInfoUseCase) :
    BaseViewModel() {

    private val _post = MutableLiveData<PostInfo>()
    val post: LiveData<PostInfo> get() = _post

    private val TAG = "WeatherViewModel"

    fun onGetAPI(
        lat: Double,
        lon: Double,
        units: String
    ) {
        val getWeatherRequest = GetWeatherRequest()
        getWeatherRequest.appId = BuildConfig.CLIENT_ID
        getWeatherRequest.latitude = lat
        getWeatherRequest.longitude = lon
        getWeatherRequest.units = units

//        val getWeatherRequest = GetWeatherRequest().apply {
//            appId = BuildConfig.CLIENT_ID
//            latitude = lat
//            longitude = lon
//            units = unit
//        }

        disposable.add(
            getWeatherInfoUseCase.execute(getWeatherRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    //view đại diện cho WeatherViewImpl
                    getAPIFail(it.toString())
                }
                .subscribe {
                    getAPISuccessful(it)
                }
        )
    }

    fun getAPIFail(message: String) {
        Log.d(TAG, message)
    }

    fun getAPISuccessful(post: PostInfo) {
        Log.d(TAG, "Success !")
        _post.value = post
    }

}