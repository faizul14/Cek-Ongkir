package com.example.cekongkir.network


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiService {

//    @Headers("key 005b795c99b91af2272f340850f9f13c")
    @GET ("province")
    fun getProvinsi(
        @Header("key") key: String
    ) : Call<Rajaongkir>
//    @Headers("key 005b795c99b91af2272f340850f9f13c")
//    @GET ("province")
//    fun getProvinsi(
//    ) : Call<Rajaongkir>
}