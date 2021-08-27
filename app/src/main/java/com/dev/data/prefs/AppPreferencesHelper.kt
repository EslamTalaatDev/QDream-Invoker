package com.dev.data.prefs


import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.dev.R
import com.dev.utils.Constants


@Suppress("DEPRECATION")
@SuppressLint("ParcelCreator")
class AppPreferencesHelper(var mContex: Context) {



    private val prefance: SharedPreferences
        get()  = PreferenceManager.getDefaultSharedPreferences(mContex)



      fun saveData(key: String, data: String) = prefance.edit().putString(key, data).apply()
      fun getData(key: String): String = prefance.getString(key, "")!!


}
