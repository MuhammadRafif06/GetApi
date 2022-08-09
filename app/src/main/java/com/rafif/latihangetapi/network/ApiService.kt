package com.rafif.latihangetapi.network

import com.rafif.latihangetapi.data.UserResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUser() : Call<ArrayList<UserResponseItem>>
}