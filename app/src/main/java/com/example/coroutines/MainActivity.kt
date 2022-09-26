package com.example.coroutines

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val TAG = "TAG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }
    }
        // launch
    /*private suspend fun printFollowers() {
        var fbFollowers = 0
        val jab = CoroutineScope(Dispatchers.IO).launch {
            fbFollowers = getFbFollowers()
        }
        jab.join()
        Log.d(TAG, fbFollowers.toString())
    }*/

    // async

    private suspend fun printFollowers(){
        val job = CoroutineScope(Dispatchers.IO).async {
            printFollowers1()
            "Gaddar"
        }
        Log.d(TAG, job.await().toString())
    }

    private suspend fun printFollowers1(){
        var fbFollowers = 0
        var instaFollowers = 0
        val job1 = CoroutineScope(Dispatchers.IO).launch{
            fbFollowers = getFbFollowers()
        }

        val job2 = CoroutineScope(Dispatchers.IO).launch {
            instaFollowers = geInstaFollowers()
        }
        job1.join()
        job2.join()

        Log.d(TAG, "Fb - $fbFollowers , Insta - $instaFollowers")
    }

    private suspend fun  getFbFollowers(): Int {
        delay(1000)
        return 54
    }
    private suspend fun geInstaFollowers(): Int {
        delay(1000)
        return 113
    }
}