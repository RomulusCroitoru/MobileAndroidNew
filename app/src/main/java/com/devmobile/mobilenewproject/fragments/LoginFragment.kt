package com.devmobile.mobilenewproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.devmobile.mobilenewproject.BuildConfig
import com.devmobile.mobilenewproject.R
import com.devmobile.mobilenewproject.databinding.FragmentLoginBinding
import com.devmobile.mobilenewproject.models.api.LoginAPIResponseModel
import com.devmobile.mobilenewproject.ui.login.LoginFragmentviewModel
import com.devmobile.mobilenewproject.utils.extensions.VolleyRequestQueue
import com.devmobile.mobilenewproject.utils.extensions.logErrorMessage
import com.devmobile.mobilenewproject.utils.extensions.showToast
import com.google.gson.Gson

class LoginFragment: Fragment(), LoginFragmentListener {



    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginFragmentviewModel by viewModels()


    //spunem fragmentului ce  layout sa foloseasca (fragment_login)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.listener = this // va fi setat in xml (avem actiunea de Login Register Forgot)
        binding.viewModel = viewModel // am legat view model de parametru din layout

        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //daca suntem in debug mode seteaza username si password
        // ii dau o valoiare acestui parametru si acesta mi o va afisa in fragment login
        if(BuildConfig.DEBUG){
            viewModel.username.set("mor_2314")
            viewModel.password.set("83r5^_")
        }

    }

    // Go to Register Fragment
    override fun goToRegister() {
        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        findNavController().navigate(action)
    }

    // Go to Products Fragment
    private fun goToProducts() {
        val action = LoginFragmentDirections.actionLoginFragmentToProductsFragments()
        findNavController().navigate(action)
    }


    override fun doLogin() {

        //validare null sau empty
        // invalid user or password
        val username = when (viewModel.username.get()?.isNotEmpty()) {
            true -> viewModel.username.get() ?: ""
            else -> {
                getString(R.string.authentication_invalid_username).showToast(context)
                return
            }
        }
        val password = when (viewModel.password.get()?.isNotEmpty()) {
            true -> viewModel.password.get() ?: ""
            else -> {
                getString(R.string.authentication_invalid_password).showToast(context)
                return
            }
        }

//        val loginAPIRequestModel = LoginAPIRequestModel(
//            username = username,
//            password = password
//        )

        val url = "https://fakestoreapi.com/auth/login"

        //trimitem tokenul at cand se realizeaza loginul si ne redirectionam catre products
        //(apelare api si callback pt raps/eroare)
        val stringRequest = object : StringRequest(
            Request.Method.POST,
            url,
            { response ->
                Gson().fromJson(response, LoginAPIResponseModel::class.java).let { responseModel ->
                    responseModel.token.showToast(context)
                    goToProducts()
                }
            },
            {
                "Login didn't work!".logErrorMessage()
            }) {
            override fun getParams(): MutableMap<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["username"] = username
                params["password"] = password
                return params
            }
        }

        //folosesc coada noastra
        VolleyRequestQueue.addToRequestQueue(stringRequest)

    }
    override fun forgotPassword() {
    }

}

interface LoginFragmentListener {
    fun doLogin()
    fun forgotPassword()
    fun goToRegister()

}