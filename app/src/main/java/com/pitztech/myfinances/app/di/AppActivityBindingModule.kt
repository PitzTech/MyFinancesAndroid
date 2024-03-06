package com.pitztech.myfinances.di

import com.pitztech.myfinances.MainActivity
import com.pitztech.myfinances.di.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}