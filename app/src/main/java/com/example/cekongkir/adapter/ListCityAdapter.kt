package com.example.cekongkir.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cekongkir.databinding.CardListProvinsiBinding
import com.example.cekongkir.network.response.ResultsItemCity

class ListCityAdapter : RecyclerView.Adapter<ListCityAdapter.CityViewHolder>() {
    private val dataCity = ArrayList<ResultsItemCity>()
    fun setData (data : List<ResultsItemCity>){
        dataCity.clear()
        dataCity.addAll(data)
    }
    class CityViewHolder(private val binding : CardListProvinsiBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data : ResultsItemCity){
            binding.txtProvinsi.setText(data.cityName.toString())
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListCityAdapter.CityViewHolder {
        val view = CardListProvinsiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListCityAdapter.CityViewHolder, position: Int) {
        holder.bind(dataCity[position])
    }

    override fun getItemCount() = dataCity.size
}