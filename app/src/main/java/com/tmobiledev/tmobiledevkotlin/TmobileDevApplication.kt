package com.tmobiledev.tmobiledevkotlin

import android.app.Application
import com.tmobiledev.tmobiledevkotlin.di.RetrofitModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class TmobileDevApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
//            androidLogger(Level.DEBUG)
            androidContext(this@TmobileDevApplication)
            modules(listOf(
                RetrofitModules
            ))
        }
    }
}