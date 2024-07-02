package com.devmobile.mobilenewproject

import android.app.Application

//o configuram pe manifest
class ApplicationController: Application() {


    //creaza o instanta a clasei noastra ce are niste proprietati ce pot fi acesate in orice clasa
    companion object {
        lateinit var instance: ApplicationController
        //private ca acest param sa nu isi schimbe valoarea din alta parte
            private set
    }


    override fun onCreate() {
        super.onCreate()

        instance = this
    }

}