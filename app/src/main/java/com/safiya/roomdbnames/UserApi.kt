package com.safiya.roomdbnames

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("/safiyaAkhtarDev/981623420b351b7e11c55a44990402c9/raw/5e279cc72ff29600e5f954ba53cdfed019c87884/usernames.json")
    suspend fun getData()
            : Response<List<UserEntity>>;
}