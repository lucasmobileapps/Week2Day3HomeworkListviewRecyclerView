package com.example.week2day3homeworklistviewrecyclerview.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.week2day3homeworklistviewrecyclerview.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnActivityAnimal: TextView = findViewById(R.id.btnActivityAnimal)
        btnActivityAnimal.setOnClickListener {
            val intent = Intent(this, ListviewActivity::class.java)
            startActivity(intent)
        }

    }
}
