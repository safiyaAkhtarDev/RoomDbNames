package com.safiya.roomdbnames

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    var recyclernames: RecyclerView? = null;
    var linearLayoutManager: LinearLayoutManager? = null
    private lateinit var adapter: RecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);


        recyclernames = findViewById(R.id.recyclernames)

        linearLayoutManager = LinearLayoutManager(this)
        recyclernames?.layoutManager = linearLayoutManager

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "userNames.db"
        ).build()
        insertUserNames(db);

    }

    private fun insertUserNames(db: AppDatabase) {

        //First Let's Delete the Existing names otherwise repeated data
//        db.UserDao().deleteAll()
        AsyncTask.execute {
            db.UserDao().insertAll(UserEntity("safiya akhtar"))
            db.UserDao().insertAll(UserEntity("john doe"))
            db.UserDao().insertAll(UserEntity("liam jack"))
            db.UserDao().insertAll(UserEntity("johanna"))
            db.UserDao().insertAll(UserEntity("joshua"))
            db.UserDao().insertAll(UserEntity("medona plake"))
            db.UserDao().insertAll(UserEntity("marine jacker"))
            db.UserDao().insertAll(UserEntity("monica geller"))
            db.UserDao().insertAll(UserEntity("ross geller"))
            db.UserDao().insertAll(UserEntity("chandler bing"))
            db.UserDao().insertAll(UserEntity("rachel green"))
            db.UserDao().insertAll(UserEntity("pheobe boofay"))

        }

        showinRecycler(db)
    }

    private fun showinRecycler(db: AppDatabase) {
        var namesList: ArrayList<UserEntity>? = null
        AsyncTask.execute() {
            namesList = db.UserDao().getAll() as ArrayList<UserEntity>;
            runOnUiThread {
                adapter = RecyclerAdapter(namesList!!)
                recyclernames?.adapter = adapter
            }
        }


    }
}