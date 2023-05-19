package com.cathaywork.demo.utils.http

import com.cathaywork.demo.Interface.IHttpPost
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HttpPostCtrl {
    var APICode = 0
    lateinit var callback:IHttpPost
    constructor(APICode:Int,callback:IHttpPost){
        this.APICode = APICode
        this.callback = callback
    }
    fun get() = GlobalScope.launch {
        var okhttp = OkHttpSender(APICode)
        callback.onResult(okhttp.get())
    }
}