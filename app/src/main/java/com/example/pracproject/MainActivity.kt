package com.example.pracproject

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.*
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var btnNext: Button? = null
    var TAG = "test"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ${Thread.currentThread().id} ")

        btnNext = findViewById(R.id.btn_next)

        btnNext?.setOnClickListener {
//            startActivity(Intent(this, MainActivity2::class.java))
//            finish()
        }
        Log.d("varun", "onCreate: ")

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(Intent(this, FirstService::class.java))
        } else {
            startService(Intent(this, FirstService::class.java))
        } // startForegroundService(Intent(this,FloatingViewService::class.java))
    }

    override fun onStart() {
        super.onStart()
        Log.d("varun", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("varun", "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d("varun", "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("varun", "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("varun", "onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("varun", "onRestart: ")
    }
}
