package com.example.domain.base

//Base mapper between Business model (Domain layer) and Response model (Data layer)
interface BaseModelMapper<E, M> {
    //Change a response (Data layer) to info (Domain layer)
    fun fromResponseToInfo(from: E): M
}