package com.example.cekongkir.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cekongkir.databinding.CardListProvinsiBinding
import com.example.cekongkir.network.ResultsItem

class ListProvinsiAdapter : RecyclerView.Adapter<ListProvinsiAdapter.ViewHolder>() {

    private val data = ArrayList<ResultsItem>()

    fun setData(data : List<ResultsItem>){
        this.data.addAll(data)
    }
    class ViewHolder(private val binding : CardListProvinsiBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : ResultsItem){
            binding.txtProvinsi.setText(data.province.toString())
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListProvinsiAdapter.ViewHolder {
        val view = CardListProvinsiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListProvinsiAdapter.ViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size
}