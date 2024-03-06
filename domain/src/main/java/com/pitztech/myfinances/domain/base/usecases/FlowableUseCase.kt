package com.pitztech.myfinances.domain.base.usecases

import io.reactivex.Flowable

interface FlowableUseCase<R> {
    fun execute(): Flowable<R>
}