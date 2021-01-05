package com.safiya.roomdbnames

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("/usernames.json")
    fun getData()
            : Call<UserEntity>;
}