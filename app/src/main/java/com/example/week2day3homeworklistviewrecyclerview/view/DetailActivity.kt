package com.example.week2day3homeworklistviewrecyclerview.view

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.week2day3homeworklistviewrecyclerview.R
import com.example.week2day3homeworklistviewrecyclerview.model.Animal
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    val passedAnimal by lazy { intent?.getParcelableExtra<Animal>("animal")}



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        animal_textview.text = "${passedAnimal?.species}"
           category_textview.text = "Category: ${passedAnimal?.category}"
           origin_textview.text = "From : ${passedAnimal?.origin}"

           Log.d("ANIMAL",passedAnimal?.toString() ?: "")

       }

     fun onClick(view : View) {
         var mediaPlayer : MediaPlayer
        when(view.id) {
            R.id.audio_imageview -> {
                if (passedAnimal?.category == "Mammal"){
                    mediaPlayer = MediaPlayer.create(this, R.raw.mammals)
                    mediaPlayer.start()

                    Log.d("SOUND","${mediaPlayer==null}")

                }

            }
        }
    }

}
