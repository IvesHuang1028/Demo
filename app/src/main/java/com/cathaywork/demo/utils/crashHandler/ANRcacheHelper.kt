package com.cathaywork.demo.utils.crashHandler

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.FileObserver
import android.os.Process
import android.util.Log

@SuppressLint("StaticFieldLeak")
object ANRcacheHelper {
    private val TAG = "ANR"
    private const val ACTION_ANR = "android.intent.action.ANR"
    private var myReceiver: MyReceiver? = null
    private lateinit var mContext: Context
    private lateinit var fileObserver: FileObserver
    fun init(context: Context) {
        mContext = context
        myReceiver = MyReceiver()
        try {
            mContext.registerReceiver(myReceiver, IntentFilter(ACTION_ANR))
        } catch (e: Exception) {
            Log.e(TAG, "register exception : "+ e.message)
        }
        initANRListener()
    }
    /**
     * ANR broadcast receiver function
     * @input : none
     * @result : ANR broadcast
     */
    private class MyReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Log.i(TAG, "intnet = " + intent.action)
            if (intent.action == ACTION_ANR) {
                // to do
                Log.e(TAG, "===============ANR================")
                System.exit(0)
            }
        }
    }
    /**
     * ANR file detect function
     * @input : none
     * @result : ANR file exit or not
     */
    fun initANRListener() {
        fileObserver = object : FileObserver("/data/anr/", CLOSE_WRITE) {
            override fun onEvent(event: Int, path: String?) {
                Log.i("ANR", "onEvent :$path")
                if (path != null) {
                    val filepath = "/data/anr/$path"
                    if (filepath.contains("trace")) {
                        Log.e("ANR", "=================ANR==================")
                        Process.killProcess(Process.myPid())
                        System.exit(0)
                    }
                }
            }
        }
        try {
            fileObserver.startWatching()
            Log.i("ANR", "start anr monitor!")
        } catch (e: Throwable) {
            //fileObserver
            Log.e("ANR", "start anr monitor failed!")
        }
    }
}