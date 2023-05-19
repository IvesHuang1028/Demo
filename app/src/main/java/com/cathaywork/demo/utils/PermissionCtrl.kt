package com.cathaywork.demo.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import com.cathaywork.demo.Interface.ICheckPermission
import java.util.ArrayList

class PermissionCtrl (private val activity: Activity, private val callback: ICheckPermission) {
    private val TAG = this.javaClass.simpleName;

    //請求權限清單
    private val PERMISSION_REQUEST = 100
    private val MANIFEST_PERMISSION = arrayOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.INTERNET,
        Manifest.permission.ACCESS_NETWORK_STATE,
        Manifest.permission.CAMERA
    )

    companion object {
        const val INITIAL_PERMISSION = 0
        const val INITIAL_PERMISSION_GRANT = 1
        const val INITIAL_PERMISSION_DENIED = 2
        const val INITIAL_LOTTIE_FINISH = 3
        const val INITIAL_DATA = 4;
    }

    fun checkPermission() {
        val permissionList: MutableList<String> = ArrayList()
        for (strPermission in MANIFEST_PERMISSION) {
            val resultCode = ActivityCompat.checkSelfPermission(activity, strPermission)
            if (resultCode != PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "PERMISSION ADD = $strPermission")
                permissionList.add(strPermission)
            }
        }
        // 尚未同意權限
        if (permissionList.isNotEmpty()) {
            val permissions = permissionList.toTypedArray()
            ActivityCompat.requestPermissions(activity, permissions, PERMISSION_REQUEST)
        } else {
            callback.onGrantComplete(true)
        }
    }

    fun requestPermission(
        requestCode : Int ,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSION_REQUEST) {
            var isShow = true
            for(permission in permissions){
                if(!ActivityCompat.shouldShowRequestPermissionRationale(activity, permission.toString()))
                    isShow = false
            }

            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "PERMISSION_GRANTED")
                checkPermission()
            } else {
                if(!isShow) {
                    callback.onGrantComplete(false)
                }else {
                    Log.d(TAG, "PERMISSION_DENIED")
                }
            }
        }
    }

}