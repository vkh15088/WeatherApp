package com.example.weatherapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.weatherapp.R

class HomeFragment : Fragment() {

    @BindView(R.id.btnStart)
    lateinit var btnStart: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    @OnClick(R.id.btnStart)
    fun onBtnStart() {
        findNavController().navigate(R.id.action_homeFragment_to_weatherViewImpl)
    }


}