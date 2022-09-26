package com.example.coroutines

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }
    }

    private fun printFollowers() {
        var fbFollowers = 0
        CoroutineScope(Dispatchers.IO).launch {
            fbFollowers = getFbFollowers()
        }
        Log.d("TAG", fbFollowers.toString())
    }

    private fun getFbFollowers(): Int {
        return 54
    }
}