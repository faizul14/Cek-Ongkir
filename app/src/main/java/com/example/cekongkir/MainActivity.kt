package com.example.cekongkir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cekongkir.adapter.ListProvinsiAdapter
import com.example.cekongkir.databinding.ActivityMainBinding
import com.example.cekongkir.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var adapter : ListProvinsiAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.simmer.startShimmer()

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]
        adapter = ListProvinsiAdapter()
        viewModel.getAllProvinsi3()

        binding.apply {
            rvProvinsi.layoutManager = LinearLayoutManager(this@MainActivity)
            rvProvinsi.setHasFixedSize(true)
        }

        viewModel.loading.observe(this, {data ->
            if (!data){
                showLoading(false)
            }
        })


        viewModel.data.observe(this, {data ->
            if (data != null){
                binding.rvProvinsi.adapter = adapter
                adapter.setData(data)
            }
        })

    }

    override fun onResume() {
        super.onResume()
        showLoading(true)
        lifecycleScope.launch(Dispatchers.Default){
            delay(1500)
            withContext(Dispatchers.Main){
                showLoading(false)
            }
        }
    }

    private fun showLoading(loading : Boolean){
        if (!loading){
            binding.apply {
                simmer.apply {
                    stopShimmer()
                    visibility = View.GONE
                }
                rvProvinsi.visibility = View.VISIBLE
            }
        }else{
            binding.apply {
                rvProvinsi.visibility = View.GONE
                simmer.apply {
                    startShimmer()
                    visibility = View.VISIBLE
                }
            }
        }
    }
}