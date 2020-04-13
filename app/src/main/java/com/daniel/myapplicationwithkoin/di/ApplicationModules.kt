package com.daniel.myapplicationwithkoin.di

import com.daniel.myapplicationwithkoin.MainContract
import com.daniel.myapplicationwithkoin.MainPresenter
import com.daniel.myapplicationwithkoin.preferences.AppPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val applicationModule = module {
    single { AppPreferences(androidContext()) }
    factory<MainContract.MainPresenter>{
        (view: MainContract.MainView) -> MainPresenter(view)
    }
}