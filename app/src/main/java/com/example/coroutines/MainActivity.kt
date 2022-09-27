package com.example.coroutines

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.ActionMode
import android.view.View
import android.widget.Button
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val TAG = "TAG"
    private val MAINACTIVITY = "MAINACTIVITY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(MAINACTIVITY, "onCreate")
        /*CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }*/

        findViewById<Button>(R.id.button).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, AnotherActivity::class.java))
        })

    }

    override fun onStart() {
        super.onStart()
        Log.d(MAINACTIVITY, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(MAINACTIVITY, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(MAINACTIVITY, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(MAINACTIVITY, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MAINACTIVITY, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(MAINACTIVITY, "onRestart")
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

    /*private suspend fun printFollowers(){
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
    }*/

}