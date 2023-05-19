package com.cathaywork.demo.view.inital

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.airbnb.lottie.LottieAnimationView
import com.cathaywork.demo.BaseActivity
import com.cathaywork.demo.Interface.ISplash
import com.cathaywork.demo.R
import com.cathaywork.demo.utils.PermissionCtrl
import com.cathaywork.demo.view.main.MainActivity
import java.util.*

/**
 * Project : cathay demo
 * Class : SplashActivity
 * Create by Ives 2023
 * 開頭動畫
 * 可處理
 * 1. 權限
 * 2. 資料、sdk初始化
 * 3. 裝置初始化
 */
class SplashActivity : BaseActivity(), ISplash {
    private var TAG = javaClass.simpleName
    private var isComplete : Boolean = false
    val splashViewModel: SplashViewModel by lazy {
        ViewModelProvider(this).get(SplashViewModel::class.java)
    }

    private lateinit var mLottieView : LottieAnimationView
    private lateinit var mIv_Logo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setSplashViewModel();
    }
    private fun setSplashViewModel(){
        splashViewModel.init(this)
        splashViewModel.getStep().observe(this, androidx.lifecycle.Observer {
            if(it == PermissionCtrl.INITIAL_PERMISSION_GRANT){
                initView()
            }else if(it == PermissionCtrl.INITIAL_PERMISSION_DENIED){
                runOnUiThread(Runnable {
                    Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show()
                })
            } else if(it == PermissionCtrl.INITIAL_LOTTIE_FINISH){
                LottieFinish()
            } else if(it == PermissionCtrl.INITIAL_DATA) {
                isComplete = true
            }
        })
    }

    fun initView(){
        Log.d(TAG, "initView")
        setContentView(R.layout.activity_splash)
        mLottieView = findViewById(R.id.lottie)
        mIv_Logo = findViewById(R.id.ivlogo)
        splashViewModel.setLottieView(mLottieView)
        splashViewModel.getAPIAttractions()
    }
    //ctrl listener callback
    override fun LottieFinish() {
        Log.d(TAG,"LottieFinish")
        mLottieView.visibility = View.GONE
        /** 動畫完成換成顯示Logo
          * 統一動畫 淡入效果
          * 動畫完成換成顯示Logo
          * 統一動畫 淡入效果
         **/
        mIv_Logo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.alpha))
        mIv_Logo.visibility = View.VISIBLE
        Handler(Looper.getMainLooper()).postDelayed({
            while (true) {
                if(isComplete) {
                    goMainActivity()
                    break;
                }
            }
        }, 3*1000)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        splashViewModel.requestPermission(requestCode, permissions, grantResults);
    }
    fun goMainActivity() {
        Log.d(TAG,"GoMain")
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        Timer().schedule(object : TimerTask() {
            override fun run() {
                finish()
            }
        }, 2*1000)
    }
}