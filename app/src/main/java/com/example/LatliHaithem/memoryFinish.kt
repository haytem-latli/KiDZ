package com.example.LatliHaithem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.kidz.R

class memoryFinish : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory_finish)
        var Globalscore= intent.getBundleExtra("Score")?.get("All")
        var scoreLvl1 = intent.getBundleExtra("Score")?.get("Lvl1")
        var scoreLvl2 = intent.getBundleExtra("Score")?.get("Lvl2")
        var scoreLvl3 = intent.getBundleExtra("Score")?.get("Lvl3")
        var scoreLvl4 = intent.getBundleExtra("Score")?.get("Lvl4")
        val scoreView = findViewById<TextView>(R.id.GlobalscoreView)
        val lvl1 = findViewById<TextView>(R.id.lvl1score)
        val lvl2 = findViewById<TextView>(R.id.lvl2score)
        val lvl3 = findViewById<TextView>(R.id.lvl3score)
        val lvl4 = findViewById<TextView>(R.id.lvl4score)
        scoreView.setText("Global Score: "+Globalscore)
        lvl1.setText("Level 1: "+scoreLvl1)
        lvl2.setText("Level 2: "+scoreLvl2)
        lvl3.setText("Level 3: "+scoreLvl3)
        lvl4.setText("Level 4: "+scoreLvl4)
        val restartButton = findViewById<Button>(R.id.restartGameButton)
        restartButton.setOnClickListener {
            Log.d("TAG","1")
            MemoryAct().Level = 1
            Log.d("TAG","2")
            MemoryAct().scoreList = mutableListOf<Int>(0,0,0,0)
            Log.d("TAG","3")
            val intent = Intent(this,MemoryAct::class.java)
            startActivity(intent)
            Log.d("TAG","4")
        }
    }
}