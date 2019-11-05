package com.openkotlin.sample.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.openkotlin.sample.R
import kotlinx.android.synthetic.main.item.view.*

class MyRecyclerViewAdapter(private val items: List<String>) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.apply {
            // 直接使用 id 引用控件
            tvItem.text = items[position]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}