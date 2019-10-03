package com.example.week2day3homeworklistviewrecyclerview.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import com.example.week2day3homeworklistviewrecyclerview.R
import com.example.week2day3homeworklistviewrecyclerview.adapter.CategoryAdapter
import com.example.week2day3homeworklistviewrecyclerview.model.Categories
import kotlinx.android.synthetic.main.activity_listview.*
import kotlinx.android.synthetic.main.my_item_view_layout.*

class ListviewActivity : AppCompatActivity() {

    var categoryList = mutableListOf(
        Categories("Mammal"),
        Categories("Bird"),
        Categories("Reptile"),
        Categories("Amphibian"),
        Categories("Fish")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)
        setupView()

        my_Listview.setOnItemClickListener {parent, view, position, id ->
            Toast.makeText(this, "Clicked item :"+" "+position,Toast.LENGTH_SHORT).show()
            val intent = Intent(this, RecyclerviewActivity::class.java)
            intent.putExtra("category", categoryList[position].category)
            startActivity(intent)
        }
    }


    private fun setupView() {
        my_Listview.adapter = CategoryAdapter(this, categoryList)

    }
}
