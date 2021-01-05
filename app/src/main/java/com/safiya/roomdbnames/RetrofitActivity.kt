package com.safiya.roomdbnames

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class RetrofitActivity : AppCompatActivity() {
    var recyclernames: RecyclerView? = null;
    var linearLayoutManager: LinearLayoutManager? = null
    private lateinit var adapter: RecyclerAdapter

    private var userApi: UserApi? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);


        recyclernames = findViewById(R.id.recyclernames)

        linearLayoutManager = LinearLayoutManager(this)
        recyclernames?.layoutManager = linearLayoutManager

        val retrofit = Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/safiyaAkhtarDev/981623420b351b7e11c55a44990402c9/raw/9c8bb48c8eec0d43888bc825202477fda3c4aeef/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        userApi = retrofit.create(UserApi::class.java)
        Log.d("safiyas", userApi!!.getData().toString())
        AsyncTask.execute() {
            val callResponse = userApi!!.getData()
            val items = callResponse.execute().body()
            if (items != null) {
                for (i in 0 until 1) {
                    // ID
                    val id = items.id ?: 1
                    Log.d("safiyas ID: ", id.toString())

                    // Employee Name
                    val employeeName = items.name ?: "N/A"
                    Log.d("safiyas Name: ", employeeName)

                }
            }
        }
    }


    private fun showinRecycler() {
        var namesList: ArrayList<UserEntity>? = null

        adapter = RecyclerAdapter(namesList!!)
        recyclernames?.adapter = adapter


    }
}