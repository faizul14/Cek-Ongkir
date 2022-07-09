package com.example.cekongkir.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ResponseTest(

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

data class Status2(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("description")
	val description: String? = null
)

data class Rajaongkir(

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null,

	@field:SerializedName("status")
	val status: Status2? = null
)
