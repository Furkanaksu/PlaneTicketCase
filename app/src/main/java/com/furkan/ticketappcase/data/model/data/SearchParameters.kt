package com.furkan.ticketappcase.data.model.data

data class SearchParameters(
    val adult: Int?,
    val child: Int?,
    val departure_date: String?,
    val departure_dates: List<String>?,
    val display_departure_date: String?,
    val display_departure_dates: List<String>?,
    val display_return_date: Any?,
    val flight_class: String?,
    val infant: Int?,
    val is_direct: Boolean?,
    val is_domestic: Boolean?,
    val is_one_way: Boolean?,
    val is_refundable: Boolean?,
    val passenger_count: Int?,
    val passenger_servisable_count: Int?,
    val provider: Any?,
    val request_id: String?,
    val return_date: Any?,
    val senior: Int?,
    val student: Int?,
    val version: Int?
)