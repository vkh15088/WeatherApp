package com.example.weatherapp.activity

import com.example.weatherapp.R
import com.example.weatherapp.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity(
    layoutId = R.layout.activity_main
)