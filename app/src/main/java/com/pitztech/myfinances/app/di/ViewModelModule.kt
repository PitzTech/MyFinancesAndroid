package com.pitztech.myfinances.di

import androidx.lifecycle.ViewModelProvider
import com.pitztech.myfinances.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}