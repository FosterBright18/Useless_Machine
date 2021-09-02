package com.foster.uselessmachine

import android.content.IntentSender
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    lateinit var switchUseless: Switch
    lateinit var buttonLookBusy: Button
    lateinit var buttonSelfDestruct: Button
    lateinit var background: ConstraintLayout
    lateinit var lookBusyBar: ProgressBar
    lateinit var lookBusyText: TextView
   // var busyIsRunning = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        wireWidgets()

        switchUseless.setOnCheckedChangeListener { _, isChecked ->
          //  if(!busyIsRunning) {
                if (isChecked) {
                    Toast.makeText(MainActivity@ this, "Switch on", Toast.LENGTH_SHORT).show()
                    startSwitchTimer()
                } else {
                    startSwitchTimer()
                    Toast.makeText(MainActivity@ this, "Switch off", Toast.LENGTH_SHORT).show()

            //    }
            }
        }
        buttonSelfDestruct.setOnClickListener{
           // if(!busyIsRunning) {
                startButtonTimer()
           // }
        }
        buttonLookBusy.setOnClickListener{
            startBusyTimer()
        }
    }

        private fun startBusyTimer() {
            switchUseless.alpha = 0f
            buttonLookBusy.alpha = 0f
            buttonSelfDestruct.alpha = 0f
            lookBusyText.alpha = 1f
            lookBusyBar.alpha = 1F
            var lastValue = 0
            var thisValue = 0
            lookBusyText.text = "Loading Assets: $thisValue/100"
            val uselessTimer = object : CountDownTimer(7300, 70) {
                //busyIsRunning = true
                override fun onTick(millisUntilFinished: Long) {
                    if(lastValue < 99) {
                        thisValue = lastValue + 1
                        lookBusyText.text = "Loading Assets: $thisValue/100"
                        lookBusyBar.progress = thisValue
                        lastValue++
                    } else{
                        lookBusyText.text = "Loading Assets: 100/100"
                    }
                }

                override fun onFinish() {
                   // busyIsRunning = false
                    switchUseless.alpha = 1f
                    switchUseless.isActivated = false
                    buttonLookBusy.alpha = 1f
                    buttonSelfDestruct.alpha = 1f
                    buttonSelfDestruct.isActivated = false
                    lookBusyText.alpha = 0f
                    lookBusyBar.alpha = 0F
                }

            }
            uselessTimer.start()
        }

        private fun startSwitchTimer() {
            val uselessTimer = object : CountDownTimer(3000, 50) {
                override fun onTick(millisUntilFinished: Long) {
                    if(!switchUseless.isChecked){
                        cancel()
                    }
                }

                override fun onFinish() {
                    // turn the switch off
                    switchUseless.isChecked = false
                }

            }
            uselessTimer.start()
        }

        private fun startButtonTimer() {

            val uselessTimer = object : CountDownTimer(10000, 10) {
                var flash = 500L
                var red = true
                var done = true
                override fun onTick(millisUntilFinished: Long) {
                    if (done) {
                        val timerHold = object : CountDownTimer(flash, 1) {

                            override fun onTick(millisUntilFinished: Long) {
                                done = false
                            }

                            override fun onFinish() {

                                if (red) {
                                    background.setBackgroundColor(Color.argb(255, 255, 0, 0))
                                    red = false
                                } else {
                                    background.setBackgroundColor(Color.argb(255, 255, 255, 255))
                                    red = true
                                }
                                flash -= 13L

                                done = true
                            }
                        }
                        timerHold.start()
                    }
                }
                override fun onFinish() {
                    exitProcess(-1)
              }

        }
        uselessTimer.start()
    }




        private fun wireWidgets() {
            switchUseless = findViewById(R.id.switch_main_switch)
            buttonLookBusy = findViewById(R.id.button_main_lookBusy)
            buttonSelfDestruct = findViewById(R.id.button_main_selfDestruct)
            background = findViewById(R.id.ConstraintLayout_main_background)
            lookBusyBar = findViewById(R.id.progressBar_main_lookBusyBar)
            lookBusyText = findViewById(R.id.textView_main_lookBusyText)
        }

    }
