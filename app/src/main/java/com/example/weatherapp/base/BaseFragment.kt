package com.example.weatherapp.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import butterknife.ButterKnife

abstract class BaseFragment(
    @LayoutRes
    private val layoutId: Int
) : Fragment() {


    override fun onAttach(context: Context) {
        super.onAttach(context)
        getPresenter().onStartView(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        findNavController().navigate(R.id.foodListFragment)
        //Init layout to controller
        val view = inflater.inflate(layoutId, container, false)
        //Bind view id to a view
        ButterKnife.bind(this, view)
        return view
    }

    protected abstract fun getPresenter(): BasePresenter
}