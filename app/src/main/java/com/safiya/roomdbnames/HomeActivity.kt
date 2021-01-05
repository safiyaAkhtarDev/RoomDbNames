package com.safiya.roomdbnames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton

class HomeActivity : AppCompatActivity() {

    var btn_db: AppCompatButton? = null
    var btn_retrofit: AppCompatButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btn_retrofit = findViewById(R.id.btn_retrofit);
        btn_db = findViewById(R.id.btn_db);


        btn_db!!.setOnClickListener {
            val intent = Intent(this@HomeActivity, MainActivity::class.java)
            startActivity(intent)
        }

        btn_retrofit!!.setOnClickListener {
            val intent = Intent(this@HomeActivity, RetrofitActivity::class.java)
            startActivity(intent)
        }


    }
}