package com.example.LatliHaithem

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kidz.R


class ImageAct : AppCompatActivity() {
    var i =0
    val images = arrayOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5,
        R.drawable.img6,
        R.drawable.img7
    )
    val description = arrayOf(
        "Frog Frog Frog Frog Frog Frog Frog Frog Frog" +
                "Frog Frog Frog Frog Frog Frog Frog Frog",
        "Snake Snake Snake Snake Snake Snake Snake Snake" +
                "Snake Snake Snake Snake Snake Snake Snake",
        "Lion Lion Lion Lion Lion Lion Lion Lion Lion Lion" +
                "Lion Lion Lion Lion Lion Lion Lion Lion Lion",
        "Parry Parry Parry Parry Parry Parry Parry Parry Parry" +
                "Parry Parry Parry Parry Parry Parry Parry Parry",
        "Dog Dog Dog Dog Dog Dog Dog Dog Dog Dog Dog Dog Dog Dog" +
                "Dog Dog Dog Dog Dog Dog Dog Dog Dog Dog Dog Dog ",
        "chicken chicken chicken chicken chicken chicken chicken" +
                "chicken chicken chicken chicken",
        "Tiger Tiger Tiger Tiger Tiger Tiger Tiger Tiger Tiger Tiger " +
                "Tiger Tiger Tiger Tiger Tiger Tiger Tiger Tiger"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
         i=intent.getIntExtra("position",3)
        val Image = findViewById<ImageView>(R.id.imageView2)
        val text = findViewById<TextView>(R.id.descripton)
        Image.setImageResource(images[i])
        text.setText(description[i])
        val nextBtn = findViewById<Button>(R.id.Next)
        val previousBtn = findViewById<Button>(R.id.Previous)
            nextBtn.setOnClickListener {
                if (i<images.size-1){
                i++
                Image.setImageResource(images[i])
                    text.setText(description[i])
                } else nextBtn.isActivated=false
            }
        previousBtn.setOnClickListener {
            if (i>0) {
                i--
                Image.setImageResource(images[i])
                text.setText(description[i])
            }else previousBtn.isActivated=false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("Position",i)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val Image = findViewById<ImageView>(R.id.imageView2)
        val text = findViewById<TextView>(R.id.descripton)
        i=savedInstanceState.getInt("Position",0)
        Image.setImageResource(images[i])
        text.setText(description[i])


    }
}