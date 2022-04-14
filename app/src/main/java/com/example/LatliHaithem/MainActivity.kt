package com.example.LatliHaithem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.kidz.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val AlbumV = findViewById<Button>(R.id.Album)
        val GessitV = findViewById<Button>(R.id.GessIT)
        val MemoryV = findViewById<Button>(R.id.MemoryGame)
        AlbumV.setOnClickListener{
           val  intent = Intent(this,AlbumAct::class.java)
            startActivity(intent)
        }
        GessitV.setOnClickListener{
            val  intent = Intent(this,GessAct::class.java)
            startActivity(intent)
        }
        MemoryV.setOnClickListener{
            val  intent = Intent(this,MemoryAct::class.java)
            startActivity(intent)
        }

    }
}