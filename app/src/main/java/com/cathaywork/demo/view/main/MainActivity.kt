package com.cathaywork.demo.view.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cathaywork.demo.BaseActivity
import com.cathaywork.demo.Interface.ILanguageListDialogCallBack
import com.cathaywork.demo.R
import com.cathaywork.demo.databinding.ActivityMainBinding
import com.cathaywork.demo.utils.LanguageDialog

/**
 * Project : cathay demo
 * Class : MainActivity
 * Create by Ives 2023
 * 主頁面
 */
class MainActivity : BaseActivity() , ILanguageListDialogCallBack{
    private var TAG = javaClass.simpleName
    private lateinit var viewModel: MainViewModel
    private lateinit var binding : ActivityMainBinding
    private lateinit var dialog : LanguageDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContentView(binding.root)
        initView()
    }
    fun initView(){
        Log.d(TAG, "initView")
        viewModel.init(this)
        setObserve()
        binding.toolbar.setOnMenuItemClickListener{
            showDialog()
            true
        }
    }

    fun setObserve(){
        viewModel.isAppBarVisible().observe(this, Observer {
            if(it){
                binding.toolbar.visibility = VISIBLE
            }else{
                binding.toolbar.visibility = GONE
            }
        })
    }
    fun showDialog(){
        dialog = LanguageDialog(this,this)
        dialog.show()
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.tv_list_item0 -> {
                viewModel.updateLanguage(resources.getStringArray(R.array.language_code)[0])
            }
            R.id.tv_list_item1 -> {
                viewModel.updateLanguage(resources.getStringArray(R.array.language_code)[1])
            }
            R.id.tv_list_item2 -> {
                viewModel.updateLanguage(resources.getStringArray(R.array.language_code)[2])
            }
            R.id.tv_list_item3 -> {
                viewModel.updateLanguage(resources.getStringArray(R.array.language_code)[3])
            }
            R.id.tv_list_item4 -> {
                viewModel.updateLanguage(resources.getStringArray(R.array.language_code)[4])
            }
            R.id.tv_list_item5 -> {
                viewModel.updateLanguage(resources.getStringArray(R.array.language_code)[5])
            }
            R.id.tv_list_item6 -> {
                viewModel.updateLanguage(resources.getStringArray(R.array.language_code)[6])
            }
            R.id.tv_list_item7 -> {
                viewModel.updateLanguage(resources.getStringArray(R.array.language_code)[7])
            }
            R.id.tv_list_item8 -> {
                viewModel.updateLanguage(resources.getStringArray(R.array.language_code)[8])
            }
        }
        dialog.dismiss()
    }
}