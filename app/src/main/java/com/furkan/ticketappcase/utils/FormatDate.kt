package com.furkan.ticketappcase.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun formatDate(source: String): String {

   // 2016-09-02T07:00:00Z

   val inputFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
   val outputFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd")

   val date: Date = inputFormat.parse(source)
   return outputFormat.format(date)

}