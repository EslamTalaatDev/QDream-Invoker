package com.dev.ui.container.viewmodel


import androidx.databinding.ObservableField
import com.dev.ui.base.BaseViewModel
import com.dev.ui.container.navigator.ContainerNavigator


class ContainerViewModel :
    BaseViewModel<ContainerNavigator>() {


    val text: ObservableField<String> = ObservableField("Hello world!")



}