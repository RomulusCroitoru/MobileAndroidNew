package com.devmobile.mobilenewproject.managers

import android.content.Context
import com.devmobile.mobilenewproject.ApplicationController

object SharedPrefsManager {

    const val FILE_NAME = "mobilenewproject"

    const val ARG_TOKEN = "ARG_TOKEN"

    private val sharedPreferences = ApplicationController.instance.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    //scriem tokenul in fisier dupa login
    fun writeToken(token: String) = write(ARG_TOKEN, token)


    //se deschide o sesiune de scriere in fisier si se salveaza tokenul
    private fun write(key: String, value: String){
        with (sharedPreferences.edit()) {
           putString(key, value)
            apply()
        }
    }


    private fun write(key: String, value: Int) {

        with(sharedPreferences.edit()) {
            putInt(key, value)
            apply()

        }
    }

    fun readToken() = readString(ARG_TOKEN)

    private fun readString(key: String) = sharedPreferences.getString(key, null)


}
