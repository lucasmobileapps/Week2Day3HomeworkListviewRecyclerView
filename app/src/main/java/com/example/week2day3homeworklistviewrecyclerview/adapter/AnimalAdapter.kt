package com.example.week2day3homeworklistviewrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.week2day3homeworklistviewrecyclerview.R
import com.example.week2day3homeworklistviewrecyclerview.model.Animal

class AnimalAdapter(private val animalList: List<Animal>, private val animaladapterDelegate: AnimalAdapterDelegate) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {
    interface  AnimalAdapterDelegate{
        fun animalSelect(animal: Animal)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.animal_item_layout, parent, false)
        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.apply {
            speciesName.text = animalList.get(position).species
            categoryName.text = animalList.get(position).category
            viewGroup.setOnClickListener{
                animaladapterDelegate.animalSelect(animalList.get(position))
            }

        }
    }
    class AnimalViewHolder(view: View):RecyclerView.ViewHolder(view){
        val speciesName: TextView = view.findViewById(R.id.species_textview)
        val categoryName: TextView = view.findViewById(R.id.category_textview)
        val viewGroup: ConstraintLayout = view.findViewById(R.id.main_animal_layout)

    }
}
