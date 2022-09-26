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
        val fb = CoroutineScope(Dispatchers.IO).async{
            getFbFollowers()
        }

        val insta = CoroutineScope(Dispatchers.IO).async {
            geInstaFollowers()
        }

        Log.d(TAG, "Fb - ${fb.await()} , Insta - ${insta.await()}")
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