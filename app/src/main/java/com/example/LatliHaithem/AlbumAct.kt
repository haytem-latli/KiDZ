package com.example.LatliHaithem

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.kidz.R
import java.io.ByteArrayOutputStream


class AlbumAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        val img1 = findViewById<ImageView>(R.id.image1)
        val img2 = findViewById<ImageView>(R.id.image2)
        val img3 = findViewById<ImageView>(R.id.image3)
        val img4 = findViewById<ImageView>(R.id.image4)
        val img5 = findViewById<ImageView>(R.id.image5)
        val img6 = findViewById<ImageView>(R.id.image6)
        val img7 = findViewById<ImageView>(R.id.image7)
        val images = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7
        )
        intent = Intent(this, ImageAct::class.java)

        img1.setOnClickListener {
            intent.putExtra("position", 0)
            startActivity(intent)
        }
        img2.setOnClickListener {
            intent.putExtra("position", 1)
            startActivity(intent)
        }
        img3.setOnClickListener {
            intent.putExtra("position", 2)
            startActivity(intent)
        }
        img4.setOnClickListener {
            intent.putExtra("position", 3)
            startActivity(intent)
        }
        img5.setOnClickListener {
            intent.putExtra("position", 4)
            startActivity(intent)
        }
        img6.setOnClickListener {
            intent.putExtra("position", 5)
            startActivity(intent)
        }
        img7.setOnClickListener {
            intent.putExtra("position", 6)
            startActivity(intent)
        }
    }
}