package com.cathaywork.demo.view.main.fragment.item

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.cathaywork.demo.Interface.IListCallBack
import com.cathaywork.demo.R
import com.cathaywork.demo.data.AppContact
import com.cathaywork.demo.databinding.FragmentItemBinding
import com.cathaywork.demo.databinding.FragmentItemContentBinding
import com.cathaywork.demo.databinding.FragmentItemListBinding
import com.cathaywork.demo.view.main.MainViewModel

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() ,IListCallBack {
    private var TAG = this.javaClass.simpleName
    private var columnCount = 1
    private var mFragment = this
    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var binding : FragmentItemListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemListBinding.inflate(LayoutInflater.from(context))
        //var view = inflater.inflate(R.layout.fragment_item_list, container, false)
        // Set the adapter
        if (binding.root is RecyclerView) {
            with(binding.root) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyItemRecyclerViewAdapter(context,AppContact.attdata,mFragment)
            }
        }
        iniObserve()
        return binding.root
    }
    fun iniObserve(){
        viewModel.updateNow().observe(viewLifecycleOwner, androidx.lifecycle.Observer  {
            if(it){
                binding.root.adapter = MyItemRecyclerViewAdapter(requireContext(),AppContact.attdata,mFragment)
            }else{

            }
        })
    }
    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    override fun onItemClick(view: View,position: Int) {
        Log.d(TAG, "onItemClick = $position")
        val bundle = bundleOf("position" to position)
        Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)
    }

    override fun onResume() {
        super.onResume()
        viewModel.setAppBarVisible(true)
    }
}