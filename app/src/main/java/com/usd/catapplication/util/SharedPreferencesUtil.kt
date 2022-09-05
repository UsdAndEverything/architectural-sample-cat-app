package com.usd.catapplication.util

import android.content.SharedPreferences

object SharedPreferencesUtil {

    const val PREFS_FILE_NAME = "SharedPreferences"
    var prefs: SharedPreferences? = null

    private const val CAT_BREEDS_REMOTE_SOURCE_FETCH_TIME_STAMP = "TIME_STAMP"

    fun setCatBreedsRemoteSourceFetchTimeStamp() {
        prefs?.let {
            it.edit().putString(
                CAT_BREEDS_REMOTE_SOURCE_FETCH_TIME_STAMP,
                System.currentTimeMillis().toString()
            ).commit()
        }
    }

    fun getCatBreedsRemoteSourceFetchTimeStamp(): String? {
        return prefs?.getString(CAT_BREEDS_REMOTE_SOURCE_FETCH_TIME_STAMP, null)
    }

}