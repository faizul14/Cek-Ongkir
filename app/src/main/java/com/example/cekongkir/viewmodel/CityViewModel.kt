package com.example.cekongkir.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cekongkir.network.ApiConfig
import com.example.cekongkir.network.response.ResponseCity
import com.example.cekongkir.network.response.ResultsItemCity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CityViewModel(private val context: Context) : ViewModel() {
    private val _data = MutableLiveData<List<ResultsItemCity>>()
    val data : LiveData<List<ResultsItemCity>> = _data

    private val _loading = MutableLiveData<Boolean>()
    val  loading : LiveData<Boolean> = _loading


    fun getData(id : String){
        _loading.value = true
        val client = ApiConfig.getApiService(context).getCity("005b795c99b91af2272f340850f9f13c" , id)
        client.enqueue(object : Callback<ResponseCity>{
            override fun onResponse(call: Call<ResponseCity>, response: Response<ResponseCity>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null){
                    _loading.value = false
                    _data.value = responseBody.rajaongkir?.results as List<ResultsItemCity>
                }else{
                    Log.d(TAG, response.message())
                }
            }

            override fun onFailure(call: Call<ResponseCity>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }

        })
    }

    companion object{
        const val TAG = "CityViewModel"
    }

}