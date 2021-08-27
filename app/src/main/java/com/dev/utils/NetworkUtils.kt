package com.dev.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager


class NetworkUtils internal constructor()// This class is not publicly instantiable
{

    companion object {
        @SuppressLint("MissingPermission")
        fun isNetworkConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (cm != null) {
                val activeNetwork = cm.activeNetworkInfo
                return activeNetwork != null && activeNetwork.isConnectedOrConnecting
            }
            return false
        }
    }

}
