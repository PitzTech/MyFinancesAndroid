package com.pitztech.myfinances.domain.base.usecases

import io.reactivex.Completable

interface CompletableUseCase {
    fun execute(): Completable
}