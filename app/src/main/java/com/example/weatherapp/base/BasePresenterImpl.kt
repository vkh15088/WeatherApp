package com.example.weatherapp.base

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenterImpl<V : BaseFragment<*>> : BasePresenter {

    protected val disposable = CompositeDisposable()
    protected var view: V? = null
        private set

    private fun start(view: V) {
        this.view = view
    }

    override fun onStop() {
        this.view = null
    }

    override fun onDestroy() {
        disposable.clear()
    }

    override fun onStartView(view: BaseFragment<*>) {
        start(view as V)
    }

    override fun onBoardView(): BaseFragment<*> {
        return view as V
    }
}