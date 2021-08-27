package com.dev.ui.base

import android.content.res.Configuration
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import java.util.*
import androidx.appcompat.app.AppCompatActivity
import com.dev.data.prefs.AppPreferencesHelper
import com.dev.utils.CommonUtils
import com.dev.utils.Constants.LANGUAGE
import com.dev.utils.NetworkUtils
import org.koin.android.ext.android.inject

@Suppress("DEPRECATION")
abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel<*>> : AppCompatActivity(),
    BaseFragment.Callback {
    lateinit var mViewDataBinding: T
    var mViewModel: V? = null


    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    abstract val bindingVariable: Int

    /**
     * @return layout resource id
     */
    @get:LayoutRes
    abstract val layoutId: Int

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract val viewModel: V

    var isNetworkConnected: Boolean = false
        get() = NetworkUtils.isNetworkConnected(applicationContext)


    val helper: AppPreferencesHelper by inject()


    fun setLocale(language_type: String) {

        val locale = Locale(language_type)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        resources.updateConfiguration(
            config,
            resources.displayMetrics
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setLocale(helper.getData(LANGUAGE))
        performDataBinding()

    }

    fun toast(message: String) = CommonUtils.toast(message, this)


    fun getViewDataBinding(): T {
        return mViewDataBinding
    }


    fun performDataBinding() {

        mViewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        this.mViewModel = if (mViewModel == null) viewModel else mViewModel
        mViewDataBinding.setVariable(bindingVariable, mViewModel)
        mViewDataBinding.executePendingBindings()

    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }


}

