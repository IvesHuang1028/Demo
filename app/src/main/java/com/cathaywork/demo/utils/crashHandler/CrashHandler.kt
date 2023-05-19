package com.cathaywork.demo.utils.crashHandler
import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Environment
import android.os.Looper
import android.os.Process
import android.util.Log
import android.widget.Toast
import java.io.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.system.exitProcess

/**
 * Project : cathay demo
 * Class : CrashHandler
 * Create by Ives 2023
 * handle crash issue
 */
@SuppressLint("StaticFieldLeak")
object CrashHandler : Thread.UncaughtExceptionHandler{

    private val TAG = javaClass.simpleName
    private var mDefaultHandler: Thread.UncaughtExceptionHandler? = null
    private var mContext: Context? = null

    fun init(context: Context?) {
        mContext = context
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    /**
     * app crash detect function
     * @input : none
     * @result : crash exception
     */
    override fun uncaughtException(thread: Thread?, ex: Throwable?) {
        if (ex != null) {
            Log.e(TAG, "==========Crash=========")
            Log.e(TAG, obtainExceptionInfo(ex));
            Process.killProcess(Process.myPid())
            exitProcess(0)
        }
    }
    /**
     * app crash information function
     * @input : Throwable data
     * @return : crash information string data
     */
    private fun obtainExceptionInfo(throwable: Throwable): String {
        val stringWriter = StringWriter()
        val printWriter = PrintWriter(stringWriter)
        throwable.printStackTrace(printWriter)
        printWriter.close()
        return stringWriter.toString()
    }
}