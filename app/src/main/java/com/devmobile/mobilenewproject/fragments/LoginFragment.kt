package com.devmobile.mobilenewproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.devmobile.mobilenewproject.R

class LoginFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        return view
    }
    // Go to Register Fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.btn_register)
        button.setOnClickListener {goToRegister()}

        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            goToProducts()
        }
    }

    // Go to Register Fragment
    private fun goToRegister() {
        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        findNavController().navigate(action)
    }

    // Go to Products Fragment
    private fun goToProducts() {
        val action = LoginFragmentDirections.actionLoginFragmentToProductsFragments()
        findNavController().navigate(action)
    }

}