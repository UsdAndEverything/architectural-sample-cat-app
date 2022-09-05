package com.usd.catapplication

import android.app.Application
import android.content.Context
import com.usd.catapplication.util.SharedPreferencesUtil
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        app = this
        SharedPreferencesUtil.prefs = getSharedPreferences(SharedPreferencesUtil.PREFS_FILE_NAME, Context.MODE_PRIVATE)
    }

    companion object {
        lateinit var app: Application
    }

}