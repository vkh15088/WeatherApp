package com.example.weatherapp.base

interface BasePresenter {

    fun onStop()

    fun onDestroy()

    fun onPaused(){}

    fun onResumed(){}

    fun onStartView(view: BaseFragment<*>)

    fun onBoardView(): BaseFragment<*>
}