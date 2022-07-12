package com.example.cekongkir.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeCOViewModel : ViewModel() {
    private val _berat = MutableLiveData<Int>()
    val berat : LiveData<Int> = _berat

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

    companion object{
        const val isPlus = "isPlus"
        const val isMinus = "isMinus"
    }


}