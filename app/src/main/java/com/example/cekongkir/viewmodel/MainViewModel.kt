package com.example.cekongkir.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cekongkir.network.ApiConfig
import com.example.cekongkir.network.Rajaongkir
import com.example.cekongkir.network.ResultsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val _data = MutableLiveData<List<ResultsItem>?>()
    val data : LiveData<List<ResultsItem>?> = _data

    fun getAllProvinsi(){
        val client = ApiConfig.getApiService().getProvinsi("005b795c99b91af2272f340850f9f13c")
        client.enqueue(object : Callback<Rajaongkir>{
            override fun onResponse(call: Call<Rajaongkir>, response: Response<Rajaongkir>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null){
                    _data.value = responseBody.results as List<ResultsItem>
                }else{
                    Log.d(TAG, response.message())
                }
            }

            override fun onFailure(call: Call<Rajaongkir>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }

        })
    }

    companion object{
        const val TAG = "MainViewModel"
    }
}