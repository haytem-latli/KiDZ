package com.example.LatliHaithem

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.widget.*
import androidx.core.animation.addListener
import androidx.core.animation.addPauseListener
import androidx.core.view.isVisible
import com.example.kidz.R
import java.lang.ref.WeakReference
import java.util.*
import java.util.zip.Inflater

class GessAct : AppCompatActivity() {
    var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var duration = 60000
        val CurrentProgress = 1000

        val images = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7
        )
        val choices = arrayOf(
            "frog",
            "snake",
            "lion",
            "platypus",
            "dog",
            "chicken",
            "tiger"
        )
        setContentView(R.layout.activity_gess)
        val Image = findViewById<ImageView>(R.id.imagev)
        val bar = findViewById<ProgressBar>(R.id.progressBar)
        val anim = ObjectAnimator.ofInt(bar,"progress",CurrentProgress)
        bar.max = 1000
        anim.setDuration(duration.toLong())
        anim.start()
        var x=0
        val text = findViewById<TextView>(R.id.textView2)
        val b1 = findViewById<Button>(R.id.b1)
        val b2 = findViewById<Button>(R.id.b2)
        val b3 = findViewById<Button>(R.id.b3)
        val b4 = findViewById<Button>(R.id.b4)
        b1.setOnClickListener {
            if (b1.text.equals(choices[x])){
                x++
                Image.setImageResource(images[x])
                changeButtons(b1,b2,b3,b4,x)
                score+=10
                text.setText(score.toString())
                duration-=5000
                bar.setProgress(0)
                anim.setDuration(duration.toLong())
                anim.start()
            }else{
                messagePop(bar,x)

            }
        }
        b2.setOnClickListener {
            if (b2.text.equals(choices[x])){
                x++
                Image.setImageResource(images[x])
                changeButtons(b1,b2,b3,b4,x)
                score+=10
                text.setText(score.toString())
                duration-=5000
                anim.setDuration(duration.toLong())
                anim.start()
            }else{
                messagePop(bar,x)
            }
        }
        b3.setOnClickListener {
            if (b3.text.equals(choices[x])){
                x++
                Image.setImageResource(images[x])
                changeButtons(b1,b2,b3,b4,x)
                score+=10
                text.setText(score.toString())
                duration-=5000
                bar.setProgress(0)
                anim.setDuration(duration.toLong())
                anim.start()
            }else messagePop(bar,x)
        }
        b4.setOnClickListener {
            if (b4.text.equals(choices[x])) {
                x++
                score += 10
                text.setText(score.toString())
                if (x <= 6) {
                    Image.setImageResource(images[x])
                    changeButtons(b1, b2, b3, b4, x)
                    duration -= 5000
                    bar.setProgress(0)
                    anim.setDuration(duration.toLong())
                    anim.start()
                } else {
                    messagePop(bar, x)
                    anim.cancel()
                }
            } else messagePop(bar, x)
        }
        val timer = object: CountDownTimer(70000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                if (bar.progress == 1000){
                    messagePop(bar,x)
                    cancel()
                }

            }

            override fun onFinish() {

            }
        }
        timer.start()
    }


    fun changeButtons( b1: Button , b2: Button , b3: Button ,b4 : Button , i : Int ){
        if(i == 1){
            b1.setText("dog")
            b2.setText("chicken")
            b3.setText("snake")
            b4.setText("tiger")
        }
        if(i == 2){
            b1.setText("bear")
            b2.setText("frog")
            b3.setText("dog")
            b4.setText("lion")
        }
        if(i == 3){
            b1.setText("platypus")
            b2.setText("cow")
            b3.setText("spiderman")
            b4.setText("lion")
        }
        if(i == 4){
            b1.setText("frog")
            b2.setText("dog")
            b3.setText("snake")
            b4.setText("chicken")
        }
        if(i == 5){
            b1.setText("chicken")
            b2.setText("cow")
            b3.setText("lion")
            b4.setText("sheep")
        }
        if(i == 6){
            b1.setText("lion")
            b2.setText("dog")
            b3.setText("cat")
            b4.setText("tiger")
        }
    }
    fun messagePop( bar: ProgressBar , i : Int){
        val window = PopupWindow(this)
        val view = layoutInflater.inflate(R.layout.popup_layout,null)
        window.contentView = view
        window.showAsDropDown(bar)
        val againButton = view.findViewById<Button>(R.id.button)
        val text2 = view.findViewById<TextView>(R.id.textView67)
        val img = view.findViewById<ImageView>(R.id.imageView67)
        if (i == 7) img.setImageResource(R.drawable.complete)
        text2.setText("your score is "+score.toString())
        againButton.setOnClickListener {
            val t = Intent(this,GessAct::class.java)
            finish()
            startActivity(t)
        }

    }

}