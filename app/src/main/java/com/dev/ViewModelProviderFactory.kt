package com.dev

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dev.ui.container.viewmodel.ContainerViewModel
import com.dev.ui.home.viewmodel.HomeViewModel


@Suppress("UNCHECKED_CAST")
class ViewModelProviderFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ) = (when {
        modelClass.isAssignableFrom(ContainerViewModel::class.java) ->
            ContainerViewModel()
        modelClass.isAssignableFrom(HomeViewModel::class.java) ->
            HomeViewModel()
        else ->
            throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }) as T


}