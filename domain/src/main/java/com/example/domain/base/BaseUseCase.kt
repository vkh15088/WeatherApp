package com.example.domain.base

import io.reactivex.Observable

interface BaseUseCase<K, V> {

    fun execute(request: K): Observable<V>
}

//interface BaseUseBase<V>{
//    fun execute(): Observable<V>
//}