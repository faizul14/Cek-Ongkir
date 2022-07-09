package com.example.cekongkir.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class ResponseProvinsi(

	@field:SerializedName("rajaongkir")
	val rajaongkir: Rajaongkir? = null
)

@Parcelize
data class ResultsItem(

	@field:SerializedName("province")
	val province: String? = null,

	@field:SerializedName("province_id")
	val provinceId: String? = null
) : Parcelable

data class Rajaongkir(

//	@field:SerializedName("query")
//	val query: List<Any?>? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null,

	@field:SerializedName("status")
	val status: Status? = null
)

data class Status(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("description")
	val description: String? = null
)
