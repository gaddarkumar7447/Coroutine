package com.example.coroutines

import android.content.Intent
import android.database.DatabaseUtils
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.ActionMode
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val TAG = "TAG"
    private val MAINACTIVITY = "MAINACTIVITY"
    lateinit var dataBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Log.d(MAINACTIVITY, "onCreate")
        /*CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }*/
        var a = 0
        dataBinding.button.setOnClickListener(View.OnClickListener {
            dataBinding.text.text = a++.toString()
        })

        dataBinding.button1.setOnClickListener(View.OnClickListener {
            executeTask()
        })

    }


    /*override fun onStart() {
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
    }*/

    private fun executeTask(){
        for (i in 1 .. 1000000000L){

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