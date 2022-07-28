package com.example.weatherapp.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B : ViewBinding>(
    @LayoutRes
    private val layoutRes: Int
) : Fragment() {

    protected lateinit var binding: B

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getPresenter().onStartView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Init layout to controller
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        initView()
        return binding.root
    }

    protected abstract fun getPresenter(): BasePresenter
    protected abstract fun initView()
}