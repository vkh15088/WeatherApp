package com.example.weatherapp.feature.weather.view

import android.content.Context.INPUT_METHOD_SERVICE
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import com.example.domain.models.weather.PostInfo
import com.example.weatherapp.R
import com.example.weatherapp.base.BaseFragment
import com.example.weatherapp.base.BasePresenter
import com.example.weatherapp.constant.AppConstant
import com.example.weatherapp.databinding.FragmentWeatherBinding
import com.example.weatherapp.feature.weather.presenter.WeatherPresenterImpl
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class WeatherFragmentImpl : BaseFragment<FragmentWeatherBinding>(R.layout.fragment_weather),
    WeatherFragment {

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
        binding.textViewCountry.text = post.mCountryName
        binding.textViewTemp.text = post.mMain.temp
        binding.textViewWeather.text = post.mWeatherList[0].mMain
        getWeatherImage(post.mWeatherList[0].mIcon)
    }

    override fun getWeatherImage(mIcon: String) {
        Picasso.get().load("${AppConstant.WEATHER_ICON_URL}$mIcon").into(binding.imageViewWeather)
    }

    override fun getPresenter(): BasePresenter {
        return mPresenterBase
    }

    override fun initView() {
        ////Set dropdown list
        // Get the string array
        val countries: Array<out String> = resources.getStringArray(R.array.countries_array)
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_list_item_1,
            countries
        ).also { adapter ->
            binding.autocompleteLocation.setAdapter(adapter)
        }

        binding.run {
            //Show dropdown list when clicking in edittext
            autocompleteLocation.setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    autocompleteLocation.showDropDown()
                }
            }

            //After selecting an item, clear focus immediately
            autocompleteLocation.setOnItemClickListener { parent, view, position, id ->
                autocompleteLocation.clearFocus()

                //Hide keyboard
                hideKeyboard()
            }

            //Hide keyboard when clicking outside
            constraintFragmentWeather.setOnFocusChangeListener { v, hasFocus ->
                hideKeyboard()
            }

            //Show API
            textViewCountry.setOnClickListener {
                getAPI()
            }
        }
    }

    fun hideKeyboard() {
        val imm = activity!!.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view!!.windowToken, 0)
    }

    //Apply Rxjava
    //https://api.openweathermap.org/data/2.5/weather?lat=21.0294498&lon=105.8544441&units=celcius&appid=1ef3f4b9ebe15867b073004797e69219
    override fun getAPI() {
        mPresenterBase.onGetAPI(
            21.0069,
            105.825,
            "metric"
        )
    }
}