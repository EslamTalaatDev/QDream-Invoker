package com.dev.application

import android.app.Application
import android.content.Context

import com.dev.di.*
import io.realm.Realm
import io.realm.RealmConfiguration

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApp : Application() {
    lateinit var context: Context

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        val mRealmConfiguration = RealmConfiguration.Builder()
            .name("cartt")
            .schemaVersion(1) // skip if you are not managing
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.getInstance(mRealmConfiguration)
        Realm.setDefaultConfiguration(mRealmConfiguration)
          startKoin {
            androidContext(this@MyApp)
            modules(listOf( appData))
        }


    }

}
