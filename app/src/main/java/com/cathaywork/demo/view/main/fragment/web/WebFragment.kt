package com.cathaywork.demo.view.main.fragment.web

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.cathaywork.demo.R
import com.cathaywork.demo.data.AppContact
import com.cathaywork.demo.databinding.FragmentItemContentBinding
import com.cathaywork.demo.databinding.FragmentWebBinding
import com.cathaywork.demo.view.main.MainViewModel
import java.text.FieldPosition

class WebFragment : Fragment() {

    companion object {
        fun newInstance() = WebFragment()
    }

    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var binding : FragmentWebBinding
    private var mPosition: Int = 0
    private lateinit var view : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWebBinding.inflate(LayoutInflater.from(context))
        view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPosition = arguments?.getInt("position")!!
        binding.toolbar.title = AppContact.attdata.data[mPosition].name
        viewModel.setAppBarVisible(false)
        initWebView()
        initToolbar()
    }
    private fun initWebView(){
        val settings = binding.fragmentWebview.settings
        settings.javaScriptEnabled = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        binding.fragmentWebview.webViewClient = WebViewClient()
        binding.fragmentWebview.loadUrl(AppContact.attdata.data[mPosition].url)
    }
    private fun initToolbar(){
        val bundle = bundleOf("url" to mPosition)
        binding.toolbar.setNavigationOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_ThirdFragment_to_SecondFragment,bundle)
        }
    }
}