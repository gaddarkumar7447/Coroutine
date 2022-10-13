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
import org.w3c.dom.DOMImplementationSource
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private val TAG = "TAG"
    private val MAINACTIVITY = "MAINACTIVITY"
    lateinit var dataBinding: ActivityMainBinding

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        /*Log.d(MAINACTIVITY, "onCreate")*/
        /*CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }*/
        /*var a = 0

        dataBinding.text.text = a.toString()

        dataBinding.button.setOnClickListener(View.OnClickListener {
            dataBinding.text.text = a++.toString()
        })*/


        /*dataBinding.button1.setOnClickListener(View.OnClickListener {
            *//*thread(start = true) {
                executeTask()
            }*//*
            *//*CoroutineScope(Dispatchers.IO).launch {
                executeTask()
                Log.d("TAG", "1 - "+ Thread.currentThread().name)
            }

            GlobalScope.launch {
                Log.d("TAG", "2 - "+Thread.currentThread().name)
            }

            MainScope().launch {
                Log.d("TAG","3 - "+ Thread.currentThread().name)
            }*//*

        })*/

        /*CoroutineScope(Dispatchers.IO).launch {
            task1()
        }
        CoroutineScope(Dispatchers.IO).launch {
            task2()
        }*/

        /*val job = CoroutineScope(Dispatchers.IO).launch {
            callFollowers()
        }

        val des = CoroutineScope(Dispatchers.IO).async {

        }*/
        /*CoroutineScope(Dispatchers.Main).launch {
            coroutinesHierarchy()
        }*/
        GlobalScope.launch{
            execute()
        }
    }

    private suspend fun execute(){
        Log.d(TAG, "Before")

        withContext(Dispatchers.IO) {
            delay(1000)
            Log.d(TAG, "$coroutineContext")
        }
        
        Log.d(TAG, "final")
    }

    private suspend  fun coroutinesHierarchy() {
        val job = GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Parent - $coroutineContext")
            val dis = async(Dispatchers.IO) {
                Log.d(TAG, "child - $coroutineContext")
            }

        }
    }

    private suspend fun callFollowers() {
        /*var follower = 0
        val job = CoroutineScope(Dispatchers.IO).launch {
            follower = getFollowers()
        }
        job.join()*/
        /*val job = CoroutineScope(Dispatchers.IO).async {
            getFollowers()
        }

        val inst = CoroutineScope(Dispatchers.IO).async {
            getInstragram()
        }*/

        CoroutineScope(Dispatchers.IO).launch {
            val fb = async { getFollowers() }
            val instra = async { getInstragram() }
            Log.d(TAG, "Get followers ${fb.await()}")
            Log.d(TAG, "Get Instagram ${instra.await()}")
        }


    }

    private suspend fun getFollowers(): Int {
        delay(1000)
        return 50
    }

    private suspend fun getInstragram(): Int {
        delay(1000)
        return 113
    }
    /*private suspend fun task1(){
        Log.d(TAG, "Starting task 1")
        delay(5000)
        Log.d(TAG, "Ending task 1")
    }

    private suspend fun task2(){
        Log.d(TAG, "Starting task 2")
        Log.d(TAG, "Ending task 2")
    }*/


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

    private fun executeTask() {
        for (i in 1..100) {
            Log.d("E", "executing $i")
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