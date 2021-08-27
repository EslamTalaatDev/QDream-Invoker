package com.dev.ui.base

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel

import java.lang.ref.WeakReference

abstract class BaseViewModel<N> :
    ViewModel() {


    companion object {
        internal lateinit var context: Context

        fun setContext(con: Context) {
            context = con
        }

    }

    lateinit var mContext: Context


    var mIsLoading = ObservableBoolean()


    var mNavigator: WeakReference<N>? = null

    fun baseContext(): Context {
        return mContext
    }

    var isLoading = ObservableBoolean()

    fun setNavigator(navigator: N) {
        this.mNavigator = WeakReference(navigator)
    }





    fun getNavigator(): N {
        return mNavigator?.get()!!
    }




    fun finishActivity(v: View) {
        val context = v.context
        (context as Activity).finish()
    }


}
