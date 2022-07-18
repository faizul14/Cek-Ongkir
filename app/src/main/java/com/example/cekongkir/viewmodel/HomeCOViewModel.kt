package com.example.cekongkir.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cekongkir.BuildConfig
import com.example.cekongkir.network.ApiConfig
import com.example.cekongkir.network.response.ResponseCost
import com.example.cekongkir.network.response.ResultsItemC
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeCOViewModel(private val context: Context)  : ViewModel() {

    private val _berat = MutableLiveData<Int>()
    val berat : LiveData<Int> = _berat

    private val _data = MutableLiveData<List<ResultsItemC>>()
    val data : LiveData<List<ResultsItemC>> = _data

    init {
        cost()
    }


    fun setBerat(data : String, mode : String){
        when(mode){
            isPlus ->{
                if (data == ""){
                    _berat.value = 1
                }else{
                    val data2 = data.toInt() + 1
                    _berat.value = data2
                }
            }
            isMinus ->{
                if ( data != "" && data != "0"){
                    val data2 = data.toInt() - 1
                    _berat.value = data2
                }
            }
        }
    }

    private fun cost(){
        val client = ApiConfig.getApiService(context).coast("005b795c99b91af2272f340850f9f13c", "501", "114", 1700, "jne")
        client.enqueue(object : Callback<ResponseCost>{
            override fun onResponse(call: Call<ResponseCost>, response: Response<ResponseCost>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null){
                    _data.value = responseBody.rajaongkir?.results as List<ResultsItemC>
                }else{
                    Log.d(TAG, response.message())
                }
            }

            override fun onFailure(call: Call<ResponseCost>, t: Throwable) {
                Log.d(TAG, t.message.toString())

            }

        })
    }



    companion object{
        const val TAG = "HomeCOViewModel"
        const val isPlus = "isPlus"
        const val isMinus = "isMinus"
    }

}