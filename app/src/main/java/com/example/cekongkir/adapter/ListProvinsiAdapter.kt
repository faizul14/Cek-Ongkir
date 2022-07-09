package com.example.cekongkir.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cekongkir.databinding.CardListProvinsiBinding
import com.example.cekongkir.network.ResultsItem
import com.example.cekongkir.network.response.ResultsItem2

class ListProvinsiAdapter : RecyclerView.Adapter<ListProvinsiAdapter.ViewHolder>() {

    private val data = ArrayList<com.example.cekongkir.network.response.ResultsItem>()

    fun setData(data : List<com.example.cekongkir.network.response.ResultsItem>){
        this.data.addAll(data)
    }
    class ViewHolder(private val binding : CardListProvinsiBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : com.example.cekongkir.network.response.ResultsItem){
            binding.txtProvinsi.setText(data.province.toString())
            binding.cdList.setOnClickListener {
                Toast.makeText(itemView.context, data.province, Toast.LENGTH_SHORT).show()
            }
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