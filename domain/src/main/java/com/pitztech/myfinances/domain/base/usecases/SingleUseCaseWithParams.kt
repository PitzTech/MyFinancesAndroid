package com.pitztech.myfinances.domain.base.usecases

import io.reactivex.Single

interface SingleUseCaseWithParams<P, R> {
    fun execute(params: P): Single<R>?
}