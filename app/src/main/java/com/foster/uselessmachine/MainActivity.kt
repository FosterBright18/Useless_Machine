package com.foster.uselessmachine

import android.content.IntentSender
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    lateinit var switchUseless: Switch
    lateinit var buttonLookBusy: Button
    lateinit var buttonSelfDestruct: Button
    lateinit var background: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        background = findViewById(R.id.ConstraintLayout_main_background)

        wireWidgets()

        switchUseless.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(
                    MainActivity@ this,
                    "Switch on",
                    Toast.LENGTH_SHORT
                ).show()

                startSwitchTimer()

            } else {
                startSwitchTimer()
                Toast.makeText(MainActivity@ this, "Switch off", Toast.LENGTH_SHORT).show()

            }

        }
        buttonSelfDestruct.setOnClickListener{
            startButtonTimer()
        }
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
            var flash = 500L
            val uselessTimer = object : CountDownTimer(10000, flash) {
                var red = 0
                override fun onTick(millisUntilFinished: Long) {
                    if(red == 255){
                        background.setBackgroundColor(Color.argb(255, 255, 0, 0))
                        red = 0
                    } else {
                        background.setBackgroundColor(Color.argb(255, 255, 255, 255))
                        red = 255
                    }
                    flash=-100L

              }
                override fun onFinish() {
                   // turn the switch off
                   //Useles
                    exitProcess(-1)
              }

        }
        uselessTimer.start()
    }


        private fun wireWidgets() {
            switchUseless = findViewById(R.id.switch_main_switch)
            buttonLookBusy = findViewById(R.id.button_main_lookBusy)
            buttonSelfDestruct = findViewById(R.id.button_main_selfDestruct)

        }

    }
