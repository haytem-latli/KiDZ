package com.example.LatliHaithem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import com.example.kidz.R

class PopupAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        var width = dm.widthPixels
        var height = dm.heightPixels
        window.setLayout((width*0.8).toInt(), (height*0.5).toInt())
    }
}