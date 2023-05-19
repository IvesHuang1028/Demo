package com.cathaywork.demo.view.main.fragment.itemContent

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cathaywork.demo.R
import com.cathaywork.demo.data.AppContact
import com.cathaywork.demo.databinding.FragmentItemContentBinding
import com.cathaywork.demo.view.main.MainViewModel
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ItemContentFragment : Fragment(){
    companion object {
        fun newInstance() = ItemContentFragment()
    }
    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var binding : FragmentItemContentBinding
    private lateinit var recyView : RecyclerView
    private lateinit var view : View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemContentBinding.inflate(LayoutInflater.from(context))
        view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val position = arguments?.getInt("position")
        binding.toolbar.title = AppContact.attdata.data[position!!].name
        recyView = binding.recycleContent
        recyView.apply {
            adapter = ItemContentRecyclerViewAdapter(context,position!!,AppContact.attdata.data[position!!])
            layoutManager = LinearLayoutManager(context)
        }
        viewModel.setAppBarVisible(false)
        initToolbar()
    }
    private fun initToolbar(){
        binding.toolbar.setNavigationOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}
