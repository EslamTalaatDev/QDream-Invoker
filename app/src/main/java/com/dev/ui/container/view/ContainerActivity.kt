package com.dev.ui.container.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.dev.BR
import com.dev.R
import com.dev.ViewModelProviderFactory
import com.dev.databinding.ActivityContainerBinding
import com.dev.databinding.ContainerActivityBinding
import com.dev.ui.base.BaseActivity
import com.dev.ui.base.BaseViewModel
import com.dev.ui.container.navigator.ContainerNavigator
import com.dev.ui.container.viewmodel.ContainerViewModel
import com.dev.ui.home.view.HomeFragment
import com.dev.utils.CommonUtils
import org.koin.android.ext.android.inject

class ContainerActivity : BaseActivity<ActivityContainerBinding, ContainerViewModel>(),
    ContainerNavigator {


    val factory: ViewModelProviderFactory by inject()

    override val bindingVariable: Int = BR.viewModel
    override val layoutId: Int = R.layout.activity_container
    override val viewModel: ContainerViewModel
        get() {
            return ViewModelProviders.of(this, factory).get(ContainerViewModel::class.java)
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseViewModel.setContext(this)
        viewModel.setNavigator(this)
        setup()
    }


    fun setup() {
        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment.newInstance()).commit()

    }

}


