package com.cathaywork.demo.Interface

interface ICameraCallBack {
    fun onOpen()
    fun onDisconnected();
    fun onError();
    fun onCaptureComplete();
}