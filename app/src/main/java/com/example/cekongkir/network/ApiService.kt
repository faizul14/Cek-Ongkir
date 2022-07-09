package com.example.cekongkir.network


import com.example.cekongkir.network.response.Rajaongkir2
import com.example.cekongkir.network.response.ResponseTest
import com.example.cekongkir.network.response.ResultsItem2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiService {

//    @Headers("key 005b795c99b91af2272f340850f9f13c")
    @GET ("province")
    fun getProvinsi(
        @Header("key") key: String
    ) : Call<Rajaongkir>

    @GET ("province")
    fun getProvinsi2(
        @Header("key") key: String
    ) : Call<List<ResultsItem2>>

    @GET ("province")
    fun getProvinsi3(
        @Header("key") key: String
    ) : Call<ResponseTest>
//    @Headers("key 005b795c99b91af2272f340850f9f13c")
//    @GET ("province")
//    fun getProvinsi(
//    ) : Call<Rajaongkir>
}