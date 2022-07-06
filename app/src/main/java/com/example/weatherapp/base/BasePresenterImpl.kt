package com.example.weatherapp.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenterImpl<V: BaseView> : BasePresenter {

//    val inject by lazy {injectDependencies()}
    protected val disposable = CompositeDisposable()
    protected var view: V? = null
        private set

    private fun start(view: V){
        this.view = view
    }


//    fun injectDependencies() {
//        //nothing
//    }

    override fun onStop() {
        this.view = null
    }

    override fun onDestroy() {
        disposable.clear()
    }

    override fun onStartView(view: BaseView) {
        start(view as V)
    }

    override fun onBoardView(): BaseView {
        return view as V
    }
}