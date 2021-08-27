package com.dev.ui.home.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.dev.BR
import com.dev.R
import com.dev.ViewModelProviderFactory
import com.dev.databinding.FragmentHomeBinding
import com.dev.ui.base.BaseFragment
import com.dev.ui.home.navigator.HomeNavigator
import com.dev.ui.home.viewmodel.HomeViewModel
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(),
    HomeNavigator {

    val factory: ViewModelProviderFactory by inject()
    override var bindingVariable: Int = BR.viewModel
    override var layoutId: Int = R.layout.fragment_home
    override val viewModel: HomeViewModel
        get() {
            return ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)
        }

    companion object {

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    fun setUp(){

    }

}