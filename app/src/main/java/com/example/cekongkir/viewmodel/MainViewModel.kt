package com.example.cekongkir.viewmodel

import android.content.Context
import android.provider.UserDictionary.Words.APP_ID
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cekongkir.BuildConfig
import com.example.cekongkir.network.ApiConfig
import com.example.cekongkir.network.response.ResponseTest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val context: Context) : ViewModel() {
//    private val _data = MutableLiveData<List<ResultsItem>?>()
//    val data : LiveData<List<ResultsItem>?> = _data

    private val _data = MutableLiveData<List<com.example.cekongkir.network.response.ResultsItem>>()
    val data : LiveData<List<com.example.cekongkir.network.response.ResultsItem>> = _data

    private val _status = MutableLiveData<String>()
    val status : LiveData<String> = _status

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> = _loading

    fun getAllProvinsi(){
//        val client = ApiConfig.getApiService().getProvinsi("005b795c99b91af2272f340850f9f13c")
//        client.enqueue(object : Callback<Rajaongkir>{
//            override fun onResponse(call: Call<Rajaongkir>, response: Response<Rajaongkir>) {
//                val responseBody = response.body()
//                if (response.isSuccessful && responseBody != null){
//                    _data.value = responseBody.results as List<ResultsItem>
//                }else{
//                    Log.d(TAG, response.message())
//                }
//            }
//
//            override fun onFailure(call: Call<Rajaongkir>, t: Throwable) {
//                Log.d(TAG, t.message.toString())
//            }
//
//        })
    }

//    fun getAllProvinsi2 (){
//        val client = ApiConfig.getApiService().getProvinsi2("005b795c99b91af2272f340850f9f13c")
//        client.enqueue(object : Callback<List<ResultsItem2>>{
//            override fun onResponse(
//                call: Call<List<ResultsItem2>>,
//                response: Response<List<ResultsItem2>>
//            ) {
//                val responseBody = response.body()
//
//                if (response.isSuccessful && responseBody != null){
//                    _data.value = responseBody
//                }else{
//                    Log.d(TAG, response.message())
//                }
//            }
//
//            override fun onFailure(call: Call<List<ResultsItem2>>, t: Throwable) {
//                Log.d(TAG, t.message.toString())
//            }
//
//        })
//    }

    fun getAllProvinsi3(){
        _loading.value = true
        val client = ApiConfig.getApiService(context).getProvinsi3("005b795c99b91af2272f340850f9f13c")
//        val client = ApiConfig.getApiService().getProvinsi3("${BuildConfig.APP_ID}")
        client.enqueue(object  : Callback<ResponseTest>{
            override fun onResponse(call: Call<ResponseTest>, response: Response<ResponseTest>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null){
                    _loading.value = false
                    _status.value = responseBody.rajaongkir?.status?.code.toString()
                    _data.value = responseBody.rajaongkir?.results as List<com.example.cekongkir.network.response.ResultsItem>?
                }else{
                    Log.d(TAG, response.message())
                }
            }

            override fun onFailure(call: Call<ResponseTest>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }

        })
    }

    companion object{
        const val TAG = "MainViewModel"
    }
}