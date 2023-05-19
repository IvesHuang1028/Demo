package com.cathaywork.demo.view.inital

import android.animation.Animator
import android.app.Application
import android.os.Looper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.airbnb.lottie.LottieAnimationView
import com.cathaywork.demo.Interface.ICheckPermission
import com.cathaywork.demo.data.AppContact
import com.cathaywork.demo.data.AppContact.API_CODE_ATTRCTIONS
import com.cathaywork.demo.data.model.AttractionData
import com.cathaywork.demo.utils.PermissionCtrl
import com.cathaywork.demo.utils.http.HttpPostCtrl
import com.google.gson.Gson
import java.util.logging.Handler
import com.cathaywork.demo.Interface.IHttpPost as IHttpPost

class SplashViewModel(application: Application) : AndroidViewModel(application),ICheckPermission,
    Animator.AnimatorListener, IHttpPost {

    lateinit var permissionCtrl : PermissionCtrl
    private lateinit var lottieView : LottieAnimationView

    private var iStep = MutableLiveData<Int>()

    fun getStep() = iStep


    fun init(activity: SplashActivity){
        permissionCtrl = PermissionCtrl(activity,this);
        AppContact.getAllProperty(activity) //data init
        iStep.value = PermissionCtrl.INITIAL_PERMISSION
        permissionCtrl.checkPermission()
    }
    fun setLottieView(view: LottieAnimationView){
        lottieView = view
        lottieView.addAnimatorListener(this);
    }

    fun getAPIAttractions(){
        HttpPostCtrl(API_CODE_ATTRCTIONS,this).get()
    }

    fun requestPermission(
        requestCode : Int ,
        permissions: Array<String?>,
        grantResults: IntArray
    ){
        permissionCtrl.requestPermission(requestCode,permissions,grantResults)
    }

    override fun onGrantComplete(isComplete: Boolean) {
        if(isComplete)
            iStep.value = PermissionCtrl.INITIAL_PERMISSION_GRANT
        else
            iStep.value = PermissionCtrl.INITIAL_PERMISSION_DENIED
    }

    override fun onAnimationStart(p0: Animator?) {
    }

    override fun onAnimationEnd(p0: Animator?) {
        iStep.value = PermissionCtrl.INITIAL_LOTTIE_FINISH
    }

    override fun onAnimationCancel(p0: Animator?) {
    }

    override fun onAnimationRepeat(p0: Animator?) {
    }

    override fun onResult(result: String) {
        AppContact.attdata = Gson().fromJson(result,AttractionData::class.java)
        android.os.Handler(Looper.getMainLooper()).post {
            iStep.value = PermissionCtrl.INITIAL_DATA
        }

    }
}