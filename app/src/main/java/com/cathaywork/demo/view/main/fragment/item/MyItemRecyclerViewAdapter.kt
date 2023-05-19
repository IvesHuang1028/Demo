package com.cathaywork.demo.view.main.fragment.item

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.cathaywork.demo.Interface.IListCallBack
import com.cathaywork.demo.data.model.AttractionData
import com.cathaywork.demo.databinding.FragmentItemBinding

class MyItemRecyclerViewAdapter(
    private val context: Context,
    private val values: AttractionData,
    private val callback: IListCallBack
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values.data[position]
        holder.titleView.text = item.name
        holder.contentView.text = item.introduction
        if(item.images.isNotEmpty()){
            Glide.with(context)
                .load(Uri.parse(item.images[0].src))
                .into(holder.imgView)
        }
        holder.itemLayout.setOnClickListener(View.OnClickListener {
            callback.onItemClick(it,position)
        })
    }

    override fun getItemCount(): Int = values.data.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val itemLayout : RelativeLayout = binding.rlItem
        val titleView: TextView = binding.itemTitle
        val contentView: TextView = binding.itemContent
        val imgView: ImageView = binding.itemImg
    }

}