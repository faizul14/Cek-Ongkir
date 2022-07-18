package com.example.cekongkir.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cekongkir.R
import com.example.cekongkir.adapter.ListCityAdapter
import com.example.cekongkir.databinding.ActivityCityBinding
import com.example.cekongkir.helper.ViewModelFactory
import com.example.cekongkir.network.response.ResultsItem
import com.example.cekongkir.viewmodel.CityViewModel

class CityActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCityBinding
    private lateinit var adapter : ListCityAdapter
    private lateinit var viewModel : CityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "KOTA"
        binding.simmer.startShimmer()



        val data = intent.getParcelableExtra<ResultsItem>(EXTRA_DATA)
        val id = data?.provinceId

        viewModel = ViewModelProvider(this, ViewModelFactory(this))[CityViewModel::class.java]
        viewModel.getData(id.toString())

        adapter = ListCityAdapter()
        binding.apply {
            rvCity.layoutManager = LinearLayoutManager(this@CityActivity)
            rvCity.setHasFixedSize(true)
        }

        viewModel.loading.observe(this, {data->
            if (!data){
                binding.apply {
                    simmer.startShimmer()
                    simmer.visibility = View.GONE
                    rvCity.visibility = View.VISIBLE
                }
            }
        })


        viewModel.data.observe(this, {data->
            if (data != null){
                binding.rvCity.adapter = adapter
                adapter.setData(data)
            }
        })

    }

    companion object{
        const val EXTRA_DATA = "extra_data"
    }
}