package com.example.week2day3homeworklistviewrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.week2day3homeworklistviewrecyclerview.R
import com.example.week2day3homeworklistviewrecyclerview.model.Categories

class CategoryAdapter(private val context: Context, private val CategoryList: List<Categories>): BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var myView: View =
            LayoutInflater.from(context).inflate(R.layout.my_item_view_layout, parent, false)

        val animalCategory = myView.findViewById<TextView>(R.id.tvItemListview)

        animalCategory.text = CategoryList.get(position).category

        return myView

    }

    override fun getItem(position: Int): Categories {
        return CategoryList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return CategoryList.size
    }

}