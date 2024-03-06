package com.pitztech.myfinances.domain.base.usecases

interface UseCase<R> {
    fun execute(): R
}