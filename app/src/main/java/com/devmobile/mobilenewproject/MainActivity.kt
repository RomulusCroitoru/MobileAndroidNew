package com.devmobile.mobilenewproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devmobile.mobilenewproject.utils.extensions.logErrorMessage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        "onCreate".logErrorMessage()

        // fun apasa buton press me
        val button = findViewById<Button>(R.id.btn_press)
       button.setOnClickListener (object : View.OnClickListener {
           override fun onClick(v: View?) {
               goToSecondActivity()
           }
       })

    }


    override fun onStart() {
        super.onStart()
        "onStart".logErrorMessage()
    }

    override fun onResume() {
        super.onResume()
        "onResume".logErrorMessage()
    }


    override fun onPause() {
        super.onPause()
        "onPause".logErrorMessage()
    }


    override fun onStop() {
        super.onStop()
        "onStop".logErrorMessage()
    }

    override fun onDestroy() {
        super.onDestroy()
        "onDestroy".logErrorMessage()
    }

    fun goToSecondActivity() {
       val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)

        finish()
    }


}