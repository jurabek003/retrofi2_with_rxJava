package com.turgunboyevjurabek.retrofi2

import com.turgunboyevjurabek.retrofi2.databinding.ItemRvBinding
import com.turgunboyevjurabek.retrofi2.madels.Valyuta

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class AdabterRv(val list: ArrayList<Valyuta>) :
    RecyclerView.Adapter<AdabterRv.Vh>() {
    inner class Vh(val itemrv: ItemRvBinding) : ViewHolder(itemrv.root) {
        fun onBind(valyuta: Valyuta) {
            itemrv.tht1.text=valyuta.Ccy
            itemrv.tht2.text=valyuta.Rate
            itemrv.tht3.text=valyuta.Date
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

}