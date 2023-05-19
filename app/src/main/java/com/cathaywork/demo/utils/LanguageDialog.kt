package com.cathaywork.demo.utils

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.cathaywork.demo.Interface.ILanguageListDialogCallBack
import com.cathaywork.demo.R
import kotlinx.coroutines.flow.callbackFlow

class LanguageDialog (
    private val context: Context,
    private val callback : ILanguageListDialogCallBack
    ) : Dialog(context), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.language_list)
        initItem()
    }
    fun initItem(){
        var languagelist = context.resources.getStringArray(R.array.language_list)
        findViewById<TextView>(R.id.tv_list_item0).text = languagelist[0]
        findViewById<TextView>(R.id.tv_list_item0).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_list_item1).text = languagelist[1]
        findViewById<TextView>(R.id.tv_list_item1).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_list_item2).text = languagelist[2]
        findViewById<TextView>(R.id.tv_list_item2).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_list_item3).text = languagelist[3]
        findViewById<TextView>(R.id.tv_list_item3).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_list_item4).text = languagelist[4]
        findViewById<TextView>(R.id.tv_list_item4).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_list_item5).text = languagelist[5]
        findViewById<TextView>(R.id.tv_list_item5).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_list_item6).text = languagelist[6]
        findViewById<TextView>(R.id.tv_list_item6).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_list_item7).text = languagelist[7]
        findViewById<TextView>(R.id.tv_list_item7).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_list_item8).text = languagelist[8]
        findViewById<TextView>(R.id.tv_list_item8).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        callback.onClick(view!!)
    }
}