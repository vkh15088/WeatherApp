package com.example.weatherapp.base

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import java.lang.Exception

abstract class BaseActivity : AppCompatActivity() {

    private val TAG: String? = "BaseActivity"
    private lateinit var mRouter: Router

    fun getRouter(): Router {
        return mRouter
    }

    fun setRootView(controller: Controller) {
        if (::mRouter.isInitialized) {
            if (!getRouter().hasRootController()) {
                getRouter().setRoot(RouterTransaction.with(controller))
            }
        } else {
            Log.e(TAG, "The router is not isInitialized, need to restart app")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onNeedHandleLogic(savedInstanceState)

    }

    fun onNeedHandleLogic(savedInstanceState: Bundle?) {
        setContentView(layout())
        try {
            //Init router for conductor
            mRouter = Conductor.attachRouter(this, rootContainerView(), savedInstanceState)
        } catch (ex: Exception) {
        }

    }


    //Chile layout per conductor view
    abstract fun layout(): Int

    //View will be contented a conductor view
    abstract fun rootContainerView(): ViewGroup
}