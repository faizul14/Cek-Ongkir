package com.example.cekongkir.helper

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cekongkir.viewmodel.CityViewModel
import com.example.cekongkir.viewmodel.HomeCOViewModel
import com.example.cekongkir.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context : Context) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeCOViewModel::class.java)){
            return HomeCOViewModel(context) as T
        }
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(context) as T
        }
        if (modelClass.isAssignableFrom(CityViewModel::class.java)){
            return CityViewModel(context) as T
        }

        throw IllegalArgumentException("unknow viewmodel class" + modelClass.name)
        return super.create(modelClass)
    }
}