package com.example.squareoffchess.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.squareoffchess.R
import com.example.squareoffchess.data.objectModel.Card
import com.example.squareoffchess.databinding.RvItemLayoutBinding

class CardsAdapter(private val list: List<Card>) :
    RecyclerView.Adapter<CardsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return DataBindingUtil.inflate<RvItemLayoutBinding>(
            LayoutInflater.from(parent.context),
            R.layout.rv_item_layout, parent, false
        ).let {
            MyViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply{
            this.item = list[position]
            this.executePendingBindings()
        }
    }

    override fun getItemCount(): Int = list.size

    class MyViewHolder(val binding: RvItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}