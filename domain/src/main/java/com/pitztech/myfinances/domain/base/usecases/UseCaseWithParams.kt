package com.pitztech.myfinances.domain.base.usecases

/**
 * p params
 * R return type
 */
interface UseCaseWithParams<P, R> {
    fun execute(params: P): R
}