package com.example.cekongkir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cekongkir.adapter.ListProvinsiAdapter
import com.example.cekongkir.databinding.ActivityMainBinding
import com.example.cekongkir.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var adapter : ListProvinsiAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]
        adapter = ListProvinsiAdapter()
        viewModel.getAllProvinsi()

        binding.apply {
            rvProvinsi.layoutManager = LinearLayoutManager(this@MainActivity)
            rvProvinsi.setHasFixedSize(true)
            rvProvinsi.adapter = adapter
        }

        viewModel.data.observe(this, {data ->
            if (data != null){
                Toast.makeText(this, data.toString(), Toast.LENGTH_SHORT).show()
                adapter.setData(data)
            }
        })

    }
}