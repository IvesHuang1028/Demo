package com.cathaywork.demo.view.main.fragment.itemContent

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.text.Layout
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cathaywork.demo.R
import com.cathaywork.demo.data.model.Data

class ItemContentRecyclerViewAdapter (
    private val context: Context,
    private val index: Int,
    private val data: Data
    ): RecyclerView.Adapter<ItemContentRecyclerViewAdapter.MyViewHodler>() {
        class MyViewHodler(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val ll_adapter_imglist = itemView.findViewById<LinearLayout>(R.id.ll_adapter_imglist)
            val tv_title = itemView.findViewById<TextView>(R.id.tv_item_content_title)
            val tv_intro = itemView.findViewById<TextView>(R.id.tv_item_content_intro)
            val tv_address = itemView.findViewById<TextView>(R.id.tv_item_content_address_content)
            val tv_update = itemView.findViewById<TextView>(R.id.tv_item_content_update_content)
            val tv_url = itemView.findViewById<TextView>(R.id.tv_item_content_url)
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHodler {
        return MyViewHodler(LayoutInflater.from(context).inflate(R.layout.item_content_adapter,parent,false))
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: MyViewHodler, position: Int) {
        for( i in 0 until data.images.size){
            var newView: ImageView = ImageView(context)
            Glide.with(context!!)
                .load(Uri.parse(data.images[i].src))
                .into(newView)
            holder.ll_adapter_imglist.addView(newView)
        }
        holder.tv_title.text = data.name
        holder.tv_intro.text = data.introduction
        holder.tv_address.text = data.address
        holder.tv_update.text = data.modified
        holder.tv_url.text = data.url
        holder.tv_url.paint.isUnderlineText = true;
        holder.tv_url.setOnClickListener{
            val bundle = bundleOf("position" to index)
            Navigation.findNavController(it).navigate(R.id.action_SecondFragment_to_ThirdFragment,bundle)
        }
    }
}
