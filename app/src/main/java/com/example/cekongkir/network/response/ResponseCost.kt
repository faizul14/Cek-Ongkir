package com.example.cekongkir.network.response

import com.google.gson.annotations.SerializedName

data class ResponseCost(

	@field:SerializedName("rajaongkir")
	val rajaongkir: RajaongkirC? = null
)

data class RajaongkirC(

	@field:SerializedName("query")
	val query: Query? = null,

	@field:SerializedName("destination_details")
	val destinationDetails: DestinationDetails? = null,

	@field:SerializedName("origin_details")
	val originDetails: OriginDetails? = null,

	@field:SerializedName("results")
	val results: List<ResultsItemC?>? = null,

	@field:SerializedName("status")
	val status: Statusc? = null
)

data class OriginDetails(

	@field:SerializedName("city_name")
	val cityName: String? = null,

	@field:SerializedName("province")
	val province: String? = null,

	@field:SerializedName("province_id")
	val provinceId: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("postal_code")
	val postalCode: String? = null,

	@field:SerializedName("city_id")
	val cityId: String? = null
)

data class ResultsItemC(

	@field:SerializedName("costs")
	val costs: List<CostsItem?>? = null,

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)

data class Query(

	@field:SerializedName("courier")
	val courier: String? = null,

	@field:SerializedName("origin")
	val origin: String? = null,

	@field:SerializedName("destination")
	val destination: String? = null,

	@field:SerializedName("weight")
	val weight: Int? = null
)

data class DestinationDetails(

	@field:SerializedName("city_name")
	val cityName: String? = null,

	@field:SerializedName("province")
	val province: String? = null,

	@field:SerializedName("province_id")
	val provinceId: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("postal_code")
	val postalCode: String? = null,

	@field:SerializedName("city_id")
	val cityId: String? = null
)

data class CostItem(

	@field:SerializedName("note")
	val note: String? = null,

	@field:SerializedName("etd")
	val etd: String? = null,

	@field:SerializedName("value")
	val value: Int? = null
)

data class CostsItem(

	@field:SerializedName("cost")
	val cost: List<CostItem?>? = null,

	@field:SerializedName("service")
	val service: String? = null,

	@field:SerializedName("description")
	val description: String? = null
)

data class Statusc(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("description")
	val description: String? = null
)
