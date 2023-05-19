package com.cathaywork.demo.view.main

import android.app.Application
import android.os.Looper
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.cathaywork.demo.Interface.IHttpPost
import com.cathaywork.demo.data.AppContact
import com.cathaywork.demo.data.model.AttractionData
import com.cathaywork.demo.utils.PermissionCtrl
import com.cathaywork.demo.utils.http.HttpPostCtrl
import com.google.gson.Gson

class MainViewModel (application: Application) : AndroidViewModel(application),IHttpPost {
    private var toolBarVisible = MutableLiveData<Boolean>()
    private var updateNow = MutableLiveData<Boolean>()
    fun isAppBarVisible() : MutableLiveData<Boolean> {
        return toolBarVisible
    }
    fun updateNow() : MutableLiveData<Boolean> {
        return updateNow
    }
    fun init(activity: MainActivity){
        toolBarVisible.value = true
        updateNow.value = false
    }
    fun setAppBarVisible(visible:Boolean){
        toolBarVisible.value = visible
    }
    fun updateLanguage(code : String){
        AppContact.language = code
        HttpPostCtrl(AppContact.API_CODE_ATTRCTIONS,this).get()
    }

    override fun onResult(result: String) {
        AppContact.attdata = Gson().fromJson(result, AttractionData::class.java)
        android.os.Handler(Looper.getMainLooper()).post {
            updateNow.value = true
        }

    }
}