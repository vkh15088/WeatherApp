package com.example.weatherapp.feature.weather.view

import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.example.domain.models.weather.PostInfo
import com.example.weatherapp.R
import com.example.weatherapp.base.BaseFragment
import com.example.weatherapp.base.BasePresenter
import com.example.weatherapp.constant.AppConstant
import com.example.weatherapp.feature.weather.presenter.WeatherPresenterImpl
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WeatherViewImpl : BaseFragment(R.layout.fragment_weather), WeatherView {

    @BindView(R.id.editTextLocation)
    lateinit var edtLocation: EditText

    @BindView(R.id.textViewCountry)
    lateinit var txtCountry: TextView

    @BindView(R.id.textViewTemp)
    lateinit var txtTemp: TextView

    @BindView(R.id.textViewWeather)
    lateinit var txtWeather: TextView

    @BindView(R.id.imageViewWeather)
    lateinit var imgWeather: ImageView

    private val TAG = "WeatherViewImpl123"

    @Inject
    lateinit var mPresenterBase: WeatherPresenterImpl

    override fun getAPISuccessful(post: PostInfo) {
        Log.d(TAG, "Success !")
        displayData(post)
    }

    override fun getAPIFail(message: String) {
        Log.d(TAG, message)
    }

    override fun displayData(post: PostInfo) {
        txtCountry.text = post.mCountryName
        txtTemp.text = post.mMain.temp
        txtWeather.text = post.mWeatherList[0].mMain
        getWeatherImage(post.mWeatherList[0].mIcon)
    }

    override fun getWeatherImage(mIcon: String) {
        Picasso.get().load("${AppConstant.WEATHER_ICON_URL}$mIcon").into(imgWeather)
    }

    override fun getPresenter(): BasePresenter {
        return mPresenterBase
    }

    //Apply Rxjava
    override fun getAPI() {
        mPresenterBase.onGetAPI(
            21.0069,
            105.825,
            "metric"
        )
    }

    @OnClick(R.id.textViewCountry)
    fun onEdtLocation() {
        getAPI()
    }
}