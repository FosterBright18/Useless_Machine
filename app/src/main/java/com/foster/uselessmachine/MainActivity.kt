package com.foster.uselessmachine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.Switch
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var switchUseless : Switch
    lateinit var buttonLookBusy : Button
    lateinit var buttonSelfDestruct : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wireWidgets()

        switchUseless.setOnCheckedChangeListener { buttonView, isChecked ->  }
        if(switchUseless.isChecked == true) {
            Toast.makeText(MainActivity@this, "Congratulations on flipping the switch", Toast.LENGTH_SHORT).show()


        }   else{
            startSwitchTimer()
        }

    }

    private fun startSwitchTimer() {
        object : CountDownTimer(300,500){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                TODO("Not yet implemented")
            }

        }.start()
    }


    private fun wireWidgets() {
        switchUseless = findViewById(R.id.switch_main_switch)
        buttonLookBusy = findViewById(R.id.button_main_lookBusy)
        buttonSelfDestruct = findViewById(R.id.button_main_selfDestruct)

    }
}