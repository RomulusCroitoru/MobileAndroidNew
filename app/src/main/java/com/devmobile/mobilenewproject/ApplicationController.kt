package com.devmobile.mobilenewproject

import android.app.Application
import androidx.room.Room
import com.devmobile.mobilenewproject.data.AppDatabase

//o configuram pe manifest
class ApplicationController: Application() {

    lateinit var  appDatabase: AppDatabase
        private set


    //creaza o instanta a clasei noastra ce are niste proprietati ce pot fi acesate in orice clasa
    companion object {
        lateinit var instance: ApplicationController
        //private ca acest param sa nu isi schimbe valoarea din alta parte
            private set
    }


    override fun onCreate() {
        super.onCreate()

        instance = this

        //seteaza baza de date
        setupDatabase()
    }

    //seteaza baza de date
    private fun setupDatabase(){
        appDatabase = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "AndroidMobileDB"
        )
            .fallbackToDestructiveMigration() //distruge baza de date curenta pt o migrare
            .build()

    }

}