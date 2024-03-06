package com.pitztech.myfinances.di

import android.app.Application
import android.content.Context
import com.pitztech.myfinances.rx.SchedulersFacade
import com.pitztech.myfinances.domain.base.rx.SchedulerProvider
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Binds
    abstract fun providerScheduler(schedulersFacade: SchedulersFacade): SchedulerProvider
}