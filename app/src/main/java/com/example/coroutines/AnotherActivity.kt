package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class AnotherActivity : AppCompatActivity() {
    private var Second = "Second Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)
        Log.d(Second, "onCreate")
    }
    override fun onStart() {
        super.onStart()
        Log.d(Second, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(Second, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(Second, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(Second, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(Second, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(Second, "onRestart")
    }
}