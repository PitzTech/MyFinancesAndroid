package com.pitztech.myfinances.domain.base.usecases

import io.reactivex.Single

interface SingleUseCase<R> {
    fun execute(): Single<R>?
}