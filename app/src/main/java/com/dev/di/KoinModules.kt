package com.dev.di

import com.dev.ViewModelProviderFactory
import com.dev.data.prefs.AppPreferencesHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val appData = module {

    single { AppPreferencesHelper(androidContext()) }
    single { ViewModelProviderFactory() }

}





