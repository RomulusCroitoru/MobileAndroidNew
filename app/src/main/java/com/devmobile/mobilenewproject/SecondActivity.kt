package com.devmobile.mobilenewproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devmobile.mobilenewproject.utils.extensions.logErrorMessage

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

    }



    override fun onDestroy() {
        super.onDestroy()

        "onDestroy()".logErrorMessage()
    }
}