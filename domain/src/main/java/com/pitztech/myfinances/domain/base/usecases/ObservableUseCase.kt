package com.pitztech.myfinances.domain.base.usecases

import io.reactivex.Observable

interface ObservableUseCase<R> {
    fun execute(): Observable<R>?
}