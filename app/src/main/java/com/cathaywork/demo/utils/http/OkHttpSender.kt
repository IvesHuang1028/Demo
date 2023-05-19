package com.cathaywork.demo.utils.http

import com.cathaywork.demo.data.AppContact
import com.cathaywork.demo.data.AppContact.API_CODE_ATTRCTIONS
import okhttp3.*
import java.io.File
import java.util.concurrent.TimeUnit

class OkHttpSender {
    val API_TRAVEL = "https://www.travel.taipei/open-api/"
    val m_nTimeOut = 30;   //secand

    var mNowAPIcode = 0

    /**
     * 建構式
     * @Input apicode, api token
     * @result apicode 指定相對應的 post API
     */
    constructor(APIcode:Int){
        this.mNowAPIcode = APIcode
    }
    fun get (): String{
        when(mNowAPIcode){
            API_CODE_ATTRCTIONS->
                return getAttractions()
        }
        return ""
    }

    fun getAttractions() : String{
        var returnString = ""
        var okHttpClient = OkHttpClient()
        okHttpClient.newBuilder()
            .connectTimeout(m_nTimeOut.toLong(), TimeUnit.SECONDS)
            .writeTimeout(m_nTimeOut.toLong(),TimeUnit.SECONDS)
            .readTimeout(m_nTimeOut.toLong(),TimeUnit.SECONDS)
            .connectionSpecs(
                listOf(
                ConnectionSpec.MODERN_TLS,
                ConnectionSpec.COMPATIBLE_TLS,
                ConnectionSpec.CLEARTEXT)
            )
            .build();
        val builder = MultipartBody.Builder()
        builder.setType(MultipartBody.FORM)
        builder.addFormDataPart("lang",AppContact.language)
        var request: Request = Request.Builder()
            .url(API_TRAVEL + AppContact.language + "/Attractions/All")
            .header("Content-Type", "multipart/form-data")
            .header("Accept", "application/json")
            .get()
            .build()
        val call = okHttpClient.newCall(request)
        val response = call.execute()
        if (response.code() == 200) {
            returnString = response.body()!!.string()
        } else {
            returnString = response.body()!!.string()
        }
        return returnString;
    }

}