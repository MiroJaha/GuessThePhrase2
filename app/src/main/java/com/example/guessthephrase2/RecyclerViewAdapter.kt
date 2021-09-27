package com.example.guessthephrase2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.items_row.view.*

private var lists = mutableMapOf<Int,Int>()

class RecyclerViewAdapter(private val enters:List<String>, color : Int):RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder (itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    init {
        val size=enters.size
        if (enters.isNotEmpty()) {
            if(lists[size - 1] == null)
                lists[size-1]=color
        }
        else
            lists = mutableMapOf()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.items_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val entry = enters[position]
        val list = lists[position]

        holder.itemView.apply {
            tvResult.text = entry
            tvResult.setTextColor(list!!)
        }
    }

    override fun getItemCount()=enters.size

}