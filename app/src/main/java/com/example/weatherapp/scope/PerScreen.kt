package com.example.weatherapp.scope

import javax.inject.Scope

//Custom Scope for each Screen

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerScreen()