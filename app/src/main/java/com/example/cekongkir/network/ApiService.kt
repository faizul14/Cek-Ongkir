package com.example.cekongkir.network


import com.example.cekongkir.network.response.ResponseCity
import com.example.cekongkir.network.response.ResponseCost
import com.example.cekongkir.network.response.ResponseTest
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET ("province")
    fun getProvinsi3(
        @Header("key") key: String
    ) : Call<ResponseTest>

    @GET("city")
    fun getCity(
        @Header("key") key: String,
        @Query("province") id:String
    ) : Call<ResponseCity>

    @FormUrlEncoded
    @POST("cost")
    fun coast(
        @Header("key") key: String,
        @Field("origin") origin : String,
        @Field("destination") destination : String,
        @Field("weight") weight : Int,
        @Field("courier") courier : String,
    ) : Call<ResponseCost>


}