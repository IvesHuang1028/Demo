package com.cathaywork.demo

import android.app.Application
import com.cathaywork.demo.BuildConfig.DEBUG
import com.cathaywork.demo.utils.crashHandler.ANRcacheHelper
import com.cathaywork.demo.utils.crashHandler.CrashHandler

/**
 * Project : cathay demo
 * Class : MyApplication
 * Create by Ives 2023
 * Handle Crash issue 、ANR issue
 */
class MyApplication : Application() {
    var TAG = javaClass.simpleName

    companion object  {
        private var instance: Application? = null
        fun instance() = instance!!
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        if (!DEBUG) {
            //錯誤處理
            CrashHandler.init(this)
            //ANR處理
            ANRcacheHelper.init(this)
        }
    }
}