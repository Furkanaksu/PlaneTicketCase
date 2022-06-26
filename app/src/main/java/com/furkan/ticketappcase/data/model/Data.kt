package com.furkan.ticketappcase.data.model

import com.furkan.ticketappcase.data.model.data.Airline
import com.furkan.ticketappcase.data.model.data.Departure

data class Data(
    var data : Result?,
//    var flights: Flights?,
)

data class Result(
    val search_url: String?,
    val created_at: String?,
    var flights: Flights?,
    var airlines: ArrayList<Airline>?,
    )

data class Flights(
    val departure: ArrayList<Departure>?
)
