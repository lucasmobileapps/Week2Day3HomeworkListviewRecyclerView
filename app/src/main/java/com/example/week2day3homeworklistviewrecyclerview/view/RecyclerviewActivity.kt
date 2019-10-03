package com.example.week2day3homeworklistviewrecyclerview.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week2day3homeworklistviewrecyclerview.R
import com.example.week2day3homeworklistviewrecyclerview.adapter.AnimalAdapter
import com.example.week2day3homeworklistviewrecyclerview.model.Animal
import kotlinx.android.synthetic.main.activity_recyclerview.*

class RecyclerviewActivity : AppCompatActivity(), AnimalAdapter.AnimalAdapterDelegate {


    var animals = mutableListOf(
        Animal("Mammal", "Lion", "Africa"),
        Animal("Mammal", "Dog", "Africa"),
        Animal("Mammal", "Elephant", "Africa"),
        Animal("Bird", "Sparrow", "Africa"),
        Animal("Bird", "Dove", "Africa"),
        Animal("Bird", "Parrot", "Africa"),
        Animal("Reptile", "Turtle", "Africa"),
        Animal("Reptile", "Gecko", "Africa"),
        Animal("Reptile", "Alligator", "Africa"),
        Animal("Amphibian", "Toad", "Africa"),
        Animal("Amphibian", "Salamander", "Africa"),
        Animal("Amphibian", "Axolotl", "Africa"),
        Animal("Fish", "Carp", "Africa"),
        Animal("Fish", "Goldfish", "Africa"),
        Animal("Fish", "Catfish", "Africa")
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        val category = intent.getStringExtra("category")?: ""
        val filteredList = animals.filter {
            it.category.equals(category)
        }
        setUpView(filteredList)



    }

    fun setUpView(list: List<Animal>){


        my_Recyclerview.adapter = AnimalAdapter(list, this)
        my_Recyclerview.layoutManager = LinearLayoutManager(this)

        val itemDecorator = DividerItemDecoration(this, LinearLayout.VERTICAL)
        my_Recyclerview.addItemDecoration(itemDecorator)

    }


    override fun animalSelect(animal: Animal) {
        Toast.makeText(this, "Specie: ${animal.species}, Category: ${animal.category}",
            Toast.LENGTH_SHORT).show()

/*
        val intent = Intent(this, DetailActivity::class.java)
        intent.putParcelableArrayListExtra("animal", ArrayList(animals))
        startActivityForResult(intent, 482)

 */


        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("animal", animal)
        startActivity(intent)



    }
}
