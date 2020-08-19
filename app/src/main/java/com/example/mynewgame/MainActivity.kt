package com.example.mynewgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {

    var score: Int = 500
    var num: Int = 0
    var num2: Int = 500
    var isRunning: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar.progress = 500         //seekBar의 포인터가 50지점에 있음.
        seekBar.setEnabled(false);    //seekBar터치를 고정.

        // sart버튼을 눌렀을때 목표스코어를 설정함.
        start.setOnClickListener {
            startGame()
            setScore()
            seekBar.setEnabled(true);
            seekBarSetting()
        }

        // go  버튼을 눌렀을때 스코어 표시
        go.setOnClickListener {
            val result = (num2 - score).absoluteValue
            yourScore.text = "$score"
            seekBar.setEnabled(false);
            Toast.makeText(this@MainActivity, "your score is |$num2 - $score| = $result", Toast.LENGTH_SHORT).show() // 어떻게해야하지 ..?

        //reset 버튼을 눌렀을때 스코어표
        reset.setOnClickListener{
            reset()
        }
        }
    }
    //############################################################
    private fun startGame(){
        isRunning = !isRunning
    }

    private fun reset(){
        score = 500 //스코어 초기화
        num = 0
        num2 = 0   //목표점수 초기화
        goalRandom.text = "00"
        yourScore.text = "00"
        seekBar.progress = 500
    }

    private fun setScore() {
        val random = Random()
        val num = random.nextInt(1000)
        goalRandom.text = num.toString()
        num2 = num
    }

    private fun seekBarSetting(){
        seekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
                score = seekBar.progress
                //Toast.makeText(this@MainActivity, "Progress is " + seekBar.progress + "%", Toast.LENGTH_SHORT).show() // <- 토스트메세지로 확인하는 코드.
            }
        })
    }
}
