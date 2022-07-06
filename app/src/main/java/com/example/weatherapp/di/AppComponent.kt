package com.example.weatherapp.di

import android.app.Application
import com.google.gson.Gson
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        fun netModule(netModule: NetworkModule): Builder

        fun build(): AppComponent
    }

    fun retrofit(): Retrofit

    fun gson(): Gson

}