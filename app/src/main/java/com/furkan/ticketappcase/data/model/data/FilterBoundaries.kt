package com.furkan.ticketappcase.data.model.data

data class FilterBoundaries(
    val departureMaxDuration: Int?,
    val departurePrice: DeparturePrice?,
    val returnMaxDuration: Int?,
    val returnPrice: ReturnPrice?
)