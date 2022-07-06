package com.example.weatherapp.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import butterknife.ButterKnife
import com.bluelinelabs.conductor.Controller

abstract class BaseView : Controller() {

    val inject by lazy { injectDependencies() }
    var mContext: Context? = null
    private val TAG: String = "BaseView123"


    override fun onContextAvailable(context: Context) {
        Log.d(TAG, "onContextAvailable: ")

        super.onContextAvailable(context)
        mContext = context
        inject
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView: ")
        //init layout to controller
        val view = inflater.inflate(getLayoutId(), container, false)
        //bind view id to a view
        ButterKnife.bind(this, view)

        return view
    }

    override fun onAttach(view: View) {
        Log.d(TAG, "onAttach: ")

        super.onAttach(view)

        //Main point to attach View to Presenter
        getPresenter().onStartView(this)
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun getPresenter(): BasePresenter

    protected abstract fun injectDependencies()


    override fun onDestroyView(view: View) {
        Log.d(TAG, "onDestroyView: ")
        super.onDestroyView(view)
    }

    override fun onDetach(view: View) {
        Log.d(TAG, "onDetach: ")
        super.onDetach(view)
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
    }
}
