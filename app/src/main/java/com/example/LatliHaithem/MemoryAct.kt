package com.example.LatliHaithem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.os.bundleOf
import com.example.kidz.R

class MemoryAct : AppCompatActivity() {
    private lateinit var im0 : ImageView
    private lateinit var im1 : ImageView
    private lateinit var im2 : ImageView
    private lateinit var im3 : ImageView
    private lateinit var im4 : ImageView
    private lateinit var im5 : ImageView
    private lateinit var im6 : ImageView
    private lateinit var im7 : ImageView
    private lateinit var im8 : ImageView
    private lateinit var im9 : ImageView
    private lateinit var im10 : ImageView
    private lateinit var im11 : ImageView
    private lateinit var im12 : ImageView
    private lateinit var im13 : ImageView
    private lateinit var im14 : ImageView
    private lateinit var im15 : ImageView
    private lateinit var im16 : ImageView
    private lateinit var im17 : ImageView
    var timeLeft = 100.00
    var isCancelled = false
    var list = mutableListOf<Int>(R.drawable.animal1,R.drawable.animal1,R.drawable.animal2,R.drawable.animal2,R.drawable
        .animal3,R.drawable.animal3,R.drawable.animal4,R.drawable.animal4)
    val list1 = mutableListOf<Int>(R.drawable.animal1,R.drawable.animal1,R.drawable.animal2,R.drawable.animal2,R.drawable
        .animal3,R.drawable.animal3,R.drawable.animal4,R.drawable.animal4)
    val list2 = mutableListOf<Int>(R.drawable.animal1,R.drawable.animal1,R.drawable.animal2,R.drawable.animal2,R.drawable
        .animal3,R.drawable.animal3,R.drawable.animal4,R.drawable.animal4,R.drawable.animal5,R.drawable.animal5,R.drawable.animal6,R.drawable.animal6)
    val list3 = mutableListOf<Int>(R.drawable.animal1,R.drawable.animal1,R.drawable.animal2,R.drawable.animal2,R.drawable
        .animal3,R.drawable.animal3,R.drawable.animal4,R.drawable.animal4,R.drawable.animal5,R.drawable.animal5,R.drawable.animal6,R.drawable.animal6,R.drawable.animal7,R.drawable.animal7,R.drawable.animal8,R.drawable.animal8)
    val list4 = mutableListOf<Int>(R.drawable.animal1,R.drawable.animal1,R.drawable.animal2,R.drawable.animal2,R.drawable
        .animal3,R.drawable.animal3,R.drawable.animal4,R.drawable.animal4,R.drawable.animal5,R.drawable.animal5,R.drawable.animal6,R.drawable.animal6,R.drawable.animal7,R.drawable.animal7,R.drawable.animal8,R.drawable.animal8,R.drawable.animal9,R.drawable.animal9)
    var scoreList = mutableListOf<Int>(0,0,0,0)
    val mainList = mutableListOf<ImageView>()
    val mainListDr = mutableListOf<Int>()
    val mainListDone = mutableListOf<ImageView>()
    val alreadyList = mutableListOf<Int>()
    var counter = 0
    var counterLimit = 4
    var timeCounter = timeLeft.toInt();
    var Level = 1
    var Score = 0
    var missedAttempts = 0
    var isFree = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory)
        val progress = findViewById<ProgressBar>(R.id.progressBar)
        val startButton = findViewById<Button>(R.id.startGameButton)
        val retryButton = findViewById<Button>(R.id.retryButton)
        val nextLvlButton = findViewById<Button>(R.id.nextLvlButton)
        val prevLvlButton = findViewById<Button>(R.id.previousLvlButton)
        val levelScoreView = findViewById<TextView>(R.id.levelView)
        levelScoreView.setText("Level "+Level+" Score: "+Score)
        nextLvlButton.setEnabled(false)
        nextLvlButton.setVisibility(View.INVISIBLE)
        prevLvlButton.setVisibility(View.INVISIBLE)
        checkLevel()
        progress.setProgress(0)
        list.shuffle()
        startButton.setOnClickListener{
            isCancelled = false
            startButton.setEnabled(false)
            var timerView = findViewById<TextView>(R.id.timerView)
            timerH((timeLeft*1000).toLong(),1000,timerView,progress,startButton).start()
        }

        prevLvlButton.setOnClickListener{
            nextLvlButton.setVisibility(View.INVISIBLE)
            val levelView = findViewById<TextView>(R.id.levelView)
            levelView.setText("Level "+Level+" Score: "+scoreList[Level-1])
            missedAttempts = 0
            if(Level == 1 ){
                prevLvlButton.setEnabled(false)
                prevLvlButton.setVisibility(View.INVISIBLE)
            }

            Level -=1
            list.shuffle()
            timeCounter = timeLeft.toInt()
            checkLevel()
            retry()
        }

        nextLvlButton.setOnClickListener{
            Level+=1
            val levelView = findViewById<TextView>(R.id.levelView)
            levelView.setText("Level "+Level+" Score: "+scoreList[Level-1])
            missedAttempts = 0
            nextLvlButton.setEnabled(false)
            nextLvlButton.setVisibility(View.INVISIBLE)
            list.shuffle()
            timeCounter = timeLeft.toInt()
            checkLevel()
            if(Level >1) {
                prevLvlButton.setVisibility(View.VISIBLE)
                prevLvlButton.setEnabled(true)
            }
            retry()

        }


        retryButton.setOnClickListener(){
            val levelView = findViewById<TextView>(R.id.levelView)
            levelView.setText("Level "+Level+" Score: "+scoreList[Level-1])
            retry()
        }

    }

    fun retry(){
        timeCounter = timeLeft.toInt()
        missedAttempts = 0
        isCancelled = true
        counter = 0
        scoreList[Level-1] = 0
        Score = 0
        val progress = findViewById<ProgressBar>(R.id.progressBar)
        val startButton = findViewById<Button>(R.id.startGameButton)
        progress.setProgress(0)
        list.shuffle()
        val timerView = findViewById<TextView>(R.id.timerView)
        startButton.setEnabled(true)
        timerView.setText("Press start")
        im0 = findViewById(R.id.img0)
        im1 = findViewById(R.id.img1)
        im2 = findViewById(R.id.img2)
        im3 = findViewById(R.id.img3)
        im4 = findViewById(R.id.img4)
        im5 = findViewById(R.id.img5)
        im6 = findViewById(R.id.img6)
        im7 = findViewById(R.id.img7)
        im8 = findViewById(R.id.img8)
        im9 = findViewById(R.id.img9)
        im10 = findViewById(R.id.img10)
        im11 = findViewById(R.id.img11)
        im12 = findViewById(R.id.img12)
        im13 = findViewById(R.id.img13)
        im14 = findViewById(R.id.img14)
        im15 = findViewById(R.id.img15)
        im16 = findViewById(R.id.img16)
        im17 = findViewById(R.id.img17)
        im0.setImageResource(R.drawable.background)
        im1.setImageResource(R.drawable.background)
        im2.setImageResource(R.drawable.background)
        im3.setImageResource(R.drawable.background)
        im4.setImageResource(R.drawable.background)
        im5.setImageResource(R.drawable.background)
        im6.setImageResource(R.drawable.background)
        im7.setImageResource(R.drawable.background)
        im8.setImageResource(R.drawable.background)
        im9.setImageResource(R.drawable.background)
        im10.setImageResource(R.drawable.background)
        im11.setImageResource(R.drawable.background)
        im12.setImageResource(R.drawable.background)
        im13.setImageResource(R.drawable.background)
        im14.setImageResource(R.drawable.background)
        im15.setImageResource(R.drawable.background)
        im16.setImageResource(R.drawable.background)
        im17.setImageResource(R.drawable.background)
        mainList.clear()
        mainListDr.clear()
        mainListDone.clear()
        alreadyList.clear()
    }

    fun timerH (millisInFuture:Long,countDownInterval:Long,timerView:TextView,progress: ProgressBar,startButton:Button): CountDownTimer {
        return object: CountDownTimer(millisInFuture,countDownInterval){

            override fun onTick(p0: Long) {
                if(isCancelled) {
                    cancel()
                    startButton.setEnabled(true)
                    if(counter == counterLimit){
                        if(Level < 4){
                            timerView.setText("YOU HAVE WON! Time: "+(timeLeft-timeCounter).toString())
                            Score = Score + (timeCounter*100)-(missedAttempts*200)
                            scoreList[Level-1] = Score
                            val levelView = findViewById<TextView>(R.id.levelView)
                            levelView.setText("Level "+Level+" Score: "+scoreList[Level-1])
                            Log.d("SCORE:",Score.toString())
                        } else {
                            timerView.setText("YOU HAVE FINISHED THE GAME")
                            Score = Score + (timeCounter*100)-(missedAttempts*200)
                            scoreList[Level-1] = Score
                            startFinishAct()
                            val nextLvlButton = findViewById<Button>(R.id.nextLvlButton)
                            nextLvlButton.setVisibility(View.INVISIBLE)

                        }
                    }else {
                        timerView.setText("Press start")
                    }

                }else{
                    timeCounter = (p0/1000).toInt()
                    val levelView = findViewById<TextView>(R.id.levelView)
                    levelView.setText("Level "+Level+" Score: "+scoreList[Level-1])
                    timerView.setText("Time remaining: "+(p0/1000).toString())
                    Log.d("PROGRESS",progress.progress.toString())
                    var current = progress.progress + (100/timeLeft)
                    if(current > progress.max) current = 0.00

                    progress.setProgress(current.toInt())
                }

            }

            override fun onFinish() {
                timerView.setText("Your time is up! LOST")
                Score = Score + (timeCounter*100)-(missedAttempts*200)
                val levelView = findViewById<TextView>(R.id.levelView)
                levelView.setText("Level "+Level+" Score: "+Score)
                counter = 0

            }
        }
    }

    fun startFinishAct() {
        val intent = Intent(this,memoryFinish :: class.java)
        var b = bundleOf()
        b.putInt("All",scoreList[0]+scoreList[1]+scoreList[2]+scoreList[3])
        b.putInt("Lvl1",scoreList[0])
        b.putInt("Lvl2",scoreList[1])
        b.putInt("Lvl3",scoreList[2])
        b.putInt("Lvl4",scoreList[3])
        intent.putExtra("Score",b)
        startActivity(intent)
    }

    fun checkLevel(){
        val levelView = findViewById<TextView>(R.id.levelView)
        levelView.setText("Level "+Level+" Score: "+scoreList[Level-1])
        val imV8 = findViewById<ImageView>(R.id.img8)
        val imV9 = findViewById<ImageView>(R.id.img9)
        val imV10 = findViewById<ImageView>(R.id.img10)
        val imV11 = findViewById<ImageView>(R.id.img11)
        val imV12 = findViewById<ImageView>(R.id.img12)
        val imV13 = findViewById<ImageView>(R.id.img13)
        val imV14 = findViewById<ImageView>(R.id.img14)
        val imV15 = findViewById<ImageView>(R.id.img15)
        val imV16 = findViewById<ImageView>(R.id.img16)
        val imV17 = findViewById<ImageView>(R.id.img17)
        imV8.setVisibility(View.INVISIBLE)
        imV9.setVisibility(View.INVISIBLE)
        imV10.setVisibility(View.INVISIBLE)
        imV11.setVisibility(View.INVISIBLE)
        imV12.setVisibility(View.INVISIBLE)
        imV13.setVisibility(View.INVISIBLE)
        imV14.setVisibility(View.INVISIBLE)
        imV15.setVisibility(View.INVISIBLE)
        imV16.setVisibility(View.INVISIBLE)
        imV17.setVisibility(View.INVISIBLE)
        if(Level == 1) {
            val prevB = findViewById<Button>(R.id.previousLvlButton)
            prevB.setVisibility(View.INVISIBLE)
            prevB.setEnabled(false)
            counterLimit = 4
            timeLeft = 100.00
            list = list1
        }
        if(Level == 2){
            timeLeft = 90.00
            counterLimit = 6
            list = list2
            imV8.setVisibility(View.VISIBLE)
            imV9.setVisibility(View.VISIBLE)
            imV10.setVisibility(View.VISIBLE)
            imV11.setVisibility(View.VISIBLE)
        }
        if(Level ==3){
            timeLeft = 80.00
            counterLimit = 8
            list = list3
            Log.d("LEVL3",list.toString())
            imV8.setVisibility(View.VISIBLE)
            imV9.setVisibility(View.VISIBLE)
            imV10.setVisibility(View.VISIBLE)
            imV11.setVisibility(View.VISIBLE)
            imV12.setVisibility(View.VISIBLE)
            imV13.setVisibility(View.VISIBLE)
            imV14.setVisibility(View.VISIBLE)
            imV15.setVisibility(View.VISIBLE)
        }
        if(Level ==4){
            timeLeft = 90.00
            counterLimit = 9
            list = list4
            imV8.setVisibility(View.VISIBLE)
            imV9.setVisibility(View.VISIBLE)
            imV10.setVisibility(View.VISIBLE)
            imV11.setVisibility(View.VISIBLE)
            imV12.setVisibility(View.VISIBLE)
            imV13.setVisibility(View.VISIBLE)
            imV14.setVisibility(View.VISIBLE)
            imV15.setVisibility(View.VISIBLE)
            imV16.setVisibility(View.VISIBLE)
            imV17.setVisibility(View.VISIBLE)
        }
    }



    fun check(im:ImageView,drews:Int){
        val timerView = findViewById<TextView>(R.id.timerView)
        if(timeCounter<timeLeft && timeCounter>0) {
            if (!mainListDone.contains(im) && (!alreadyList.contains(im.id))) {
                alreadyList.add(im.id)
                if (mainList.size < 2) {
                    im.setImageResource(drews)
                    mainList.add(im)
                    mainListDr.add(drews)
                    Log.d("TAG: ", mainListDr.toString())
                    if (mainList.size == 2) {

                        Handler().postDelayed({
                            if (mainListDr[0] == mainListDr[1]) {
                                Score = (Score + 1000)
                                scoreList[Level - 1] = Score
                                mainListDone.add(mainList[0])
                                mainListDone.add(mainList[1])
                                counter += 1
                                Log.d("COINTER", counter.toString())
                                if (counter == counterLimit) {
                                    Log.d("WINNER", "WINNER")
                                    isCancelled = true

                                    val nextLvlButton = findViewById<Button>(R.id.nextLvlButton)
                                    nextLvlButton.setEnabled(true)
                                    nextLvlButton.setVisibility(View.VISIBLE)
                                }
                                alreadyList.clear()
                                mainList.clear()
                                mainListDr.clear()
                            } else {
                                missedAttempts += 1
                                mainList[0].setImageResource(R.drawable.background)
                                mainList[1].setImageResource(R.drawable.background)
                                alreadyList.clear()
                                mainList.clear()
                                mainListDr.clear()
                            }
                        },500)
                    }
                }
            }
        }
    }






    fun myMethod0(view: View) {
        im0 = findViewById(R.id.img0)
        check(im0,list[0])

    }
    fun myMethod1(view: View) {
        im1 = findViewById(R.id.img1)
        check(im1,list[1])
    }
    fun myMethod2(view: View) {
        im2 = findViewById(R.id.img2)
        check(im2,list[2])
    }
    fun myMethod3(view: View) {
        im3 = findViewById(R.id.img3)
        check(im3,list[3])
    }
    fun myMethod4(view: View) {
        im4 = findViewById(R.id.img4)
        check(im4,list[4])
    }
    fun myMethod5(view: View) {
        im5 = findViewById(R.id.img5)
        check(im5,list[5])
    }
    fun myMethod6(view: View) {
        im6 = findViewById(R.id.img6)
        check(im6,list[6])
    }
    fun myMethod7(view: View) {
        im7 = findViewById(R.id.img7)
        check(im7,list[7])
    }
    fun myMethod8(view: View) {
        im8 = findViewById(R.id.img8)
        check(im8,list[8])
    }
    fun myMethod9(view: View) {
        im9 = findViewById(R.id.img9)
        check(im9,list[9])
    }
    fun myMethod10(view: View) {
        im10 = findViewById(R.id.img10)
        check(im10,list[10])
    }
    fun myMethod11(view: View) {
        im11 = findViewById(R.id.img11)
        check(im11,list[11])
    }
    fun myMethod12(view: View) {
        im12 = findViewById(R.id.img12)
        check(im12,list[12])
    }
    fun myMethod13(view: View) {
        im13 = findViewById(R.id.img13)
        check(im13,list[13])
    }
    fun myMethod14(view: View) {
        im14 = findViewById(R.id.img14)
        check(im14,list[14])
    }
    fun myMethod15(view: View) {
        im15 = findViewById(R.id.img15)
        check(im15,list[15])
    }
    fun myMethod16(view: View) {
        im16 = findViewById(R.id.img16)
        check(im16,list[16])
    }
    fun myMethod17(view: View) {
        im17 = findViewById(R.id.img17)
        check(im17,list[17])
    }
}