package com.safiya.roomdbnames

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(MoshiConverterFactory.create().asLenient())
            .build()

        userApi = retrofit.create(UserApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {

            // Do the GET request and get response
            val response = userApi!!.getData()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    var namesList: ArrayList<UserEntity>? = ArrayList()
                    val items = response.body()
                    if (items != null) {
                        for (i in 0 until items.count()) {
                            // ID
                            val id = items[i].id ?: 0
                            Log.d("safiyas ID: ", id.toString())

                            //  Name
                            val Name = items[i].name ?: "N/A"
                            Log.d("safiyas Name: ", Name)
                            var userEntity:UserEntity= UserEntity(Name)

                            namesList!!.add(userEntity)
                        }
                           Log.d("safiyas",namesList.toString())
                        adapter = RecyclerAdapter(namesList!!)
                        recyclernames?.adapter = adapter
                    }



                } else {

                    Log.e("RETROFIT_ERROR", response.message())

                }
            }
        }

    }


    private fun showinRecycler() {


    }
}