package com.devmobile.mobilenewproject.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class LoginFragmentviewModel : ViewModel() {

    val username = ObservableField<String>()
    val password = ObservableField<String>()
}