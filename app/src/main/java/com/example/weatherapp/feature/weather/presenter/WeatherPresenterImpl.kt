package com.example.weatherapp.feature.weather.presenter

import com.example.domain.models.weather.GetWeatherRequest
import com.example.domain.usecases.weather.GetWeatherInfoUseCase
import com.example.weatherapp.BuildConfig
import com.example.weatherapp.base.BasePresenterImpl
import com.example.weatherapp.feature.weather.view.WeatherFragmentImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherPresenterImpl @Inject constructor(private val getWeatherInfoUseCase: GetWeatherInfoUseCase) :
    BasePresenterImpl<WeatherFragmentImpl>(), WeatherPresenter {

    override fun onGetAPI(
        lat: Double,
        lon: Double,
        units: String
    ) {
        val getWeatherRequest = GetWeatherRequest()
        getWeatherRequest.appId = BuildConfig.CLIENT_ID
        getWeatherRequest.latitude = lat
        getWeatherRequest.longitude = lon
        getWeatherRequest.units = units

        disposable.add(
            getWeatherInfoUseCase.execute(getWeatherRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    //view đại diện cho WeatherViewImpl
                    view?.getAPIFail(it.toString())
                }
                .subscribe {
                    view?.getAPISuccessful(it)
                }
        )
    }
}
