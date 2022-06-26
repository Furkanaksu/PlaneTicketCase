package com.furkan.ticketappcase.data.repository

import android.content.Context
import com.furkan.ticketappcase.R
import com.furkan.ticketappcase.base.BaseRepository
import com.furkan.ticketappcase.data.api.ApiServices
import com.furkan.ticketappcase.data.local.SongDao
import com.furkan.ticketappcase.data.local.Songs
import com.furkan.ticketappcase.data.model.Data
import com.google.gson.Gson
import javax.inject.Inject

class SongsRepo @Inject constructor(
    private val apiService: ApiServices,
    private val songDao: SongDao
    ) : BaseRepository() {

    suspend fun insertData(song: Songs) = songDao.addSong(song)

    suspend fun getData(context: Context) = safeApiRequest {
        val text = context.resources.openRawResource(R.raw.enuygun_flight_search).bufferedReader().use { it.readText() }
        val responseConvert: Data = Gson().fromJson(text, Data::class.java)

        return@safeApiRequest responseConvert
    }

}