package com.devmobile.mobilenewproject.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.devmobile.mobilenewproject.BuildConfig
import com.devmobile.mobilenewproject.R
import com.devmobile.mobilenewproject.data.repositories.ProductRepository
import com.devmobile.mobilenewproject.databinding.FragmentLoginBinding
import com.devmobile.mobilenewproject.models.api.LoginAPIRequestModel
import com.devmobile.mobilenewproject.models.api.LoginAPIResponseModel
import com.devmobile.mobilenewproject.utils.extensions.VolleyRequestQueue
import com.devmobile.mobilenewproject.utils.extensions.logErrorMessage
import com.devmobile.mobilenewproject.utils.extensions.showToast
import com.google.gson.Gson

class LoginFragment: Fragment(), LoginFragmentListener {


    private var usernameEditText: EditText? = null
    private var passwordEditText: EditText? = null

    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.listener = this // va fi setat in xml (avem actiunea de Login Register Forgot)

        return binding.root

    }
    // Go to Register Fragment
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usernameEditText = view.findViewById(R.id.et_username)
        passwordEditText = view.findViewById(R.id.et_password)

        //daca suntem in debug mode seteaza username si password
        if(BuildConfig.DEBUG){
            usernameEditText?.setText("mor_2314")
            passwordEditText?.setText("83r5^_")
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
        val username = when (usernameEditText?.text?.isNotEmpty()) {
            true -> usernameEditText?.text.toString()
            else -> {
                getString(R.string.authentication_invalid_username).showToast(context)
                return
            }
        }
        val password = when (passwordEditText?.text?.isNotEmpty()) {
            true -> passwordEditText?.text.toString()
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