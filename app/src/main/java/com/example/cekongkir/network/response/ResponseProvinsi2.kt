package com.example.cekongkir.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ResponseProvinsi2(

	@field:SerializedName("rajaongkir")
	val rajaongkir: Rajaongkir2? = null
)

data class Rajaongkir2(

//	@field:SerializedName("query")
//	val query: List<Any?>? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem2>,

	@field:SerializedName("status")
	val status: Status
)

@Parcelize
data class ResultsItem2(

	@field:SerializedName("province")
	val province: String,

	@field:SerializedName("province_id")
	val provinceId: String
) : Parcelable

data class Status(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("description")
	val description: String
)
