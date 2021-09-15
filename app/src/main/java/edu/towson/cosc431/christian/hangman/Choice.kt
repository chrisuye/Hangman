package edu.towson.cosc431.christian.hangman

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_choice.*

class Choice : AppCompatActivity() {
    private var colorChange = 0

    val receiver: BroadcastReceiver = object: BroadcastReceiver() {
        override fun onReceive(ctx: Context?, intent: Intent?) {

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        val spinner = findViewById<Spinner>(R.id.spinner) as Spinner
        val options = arrayOf("Single", "Two", "Custom")
        var position = 0

        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                position = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                println("nothing")
            }

        }

        // used to change the back ground color
        colorBack()

        start.setOnClickListener {
            when (position) {
                0 -> {
                    val intent = Intent(this, Singleplayer::class.java)
                    intent.putExtra("color", colorChange)
                    startActivity(intent)
                }
                1 -> {
                    val intent = Intent(this, TwoGame::class.java)
                    intent.putExtra("color", colorChange)
                    startActivity(intent)
                }
                2 -> {
                    val intent = Intent(this, CustomInput::class.java)
                    intent.putExtra("color", colorChange)
                    startActivity(intent)
                }
            }
        }


//        single_btn.setOnClickListener {
//            //starts an intent to go to the next activity to choice letter size.
//            //color is the number we use to determine the background color
//            val intent = Intent(this, Singleplayer::class.java)
//            intent.putExtra("color", colorChange)
//            startActivity(intent)
//        }
//        score_btn.setOnClickListener {
//            //starts an intent to go score
//            //color is the number we use to determine the background color
//            val intent = Intent(this, Score::class.java)
//            intent.putExtra("color", colorChange)
//            startActivity(intent)
//        }
//        custom_btn.setOnClickListener {
//            //starts an intent to go to the next activity to input word.
//            //color is the number we use to determine the background color
//            val intent = Intent(this, CustomInput::class.java)
//            intent.putExtra("color", colorChange)
//            startActivity(intent)
//        }
//        two_btn.setOnClickListener {
//            //starts an intent to go to the next activity to choice letter size.
//            //color is the number we use to determine the background color
//            val intent = Intent(this, TwoGame::class.java)
//            intent.putExtra("color", colorChange)
//            startActivity(intent)
//
//        }
//        l_btn.setOnClickListener{
//            //logs the user out of the game
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//        r_btn.setOnClickListener {
//            //changes the color to red
//            colorChange = 1
//            colorBack()
//        }
//        b_btn.setOnClickListener {
//            //change color to blue
//            colorChange = 2
//            colorBack()
//        }
//        ba_btn.setOnClickListener {
//            //change color to black
//            colorChange = 3
//            colorBack()
//        }
//        white_btn.setOnClickListener {
//            //change color to white
//            colorChange = 0
//            colorBack()
//        }
    }
    //this function controls the back ground color
    fun colorBack(){
        when(colorChange){
            0 -> choice_layout.setBackgroundColor(Color.WHITE)
            1 -> choice_layout.setBackgroundColor(Color.RED)
            2 -> choice_layout.setBackgroundColor(Color.BLUE)
            3 -> choice_layout.setBackgroundColor(Color.BLACK)
        }
    }
    //we check for activity onpause and if it is paused for long we send a notification
    override fun onPause() {
        super.onPause()
        val j = Intent(this, MyIntentService::class.java)
        startService(j)
    }
}
