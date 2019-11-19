package edu.towson.cosc431.christian.hangman

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choice.*

class Choice : AppCompatActivity() {
    private var colorChange = 0

    val receiver: BroadcastReceiver = object: BroadcastReceiver() {
        override fun onReceive(ctx: Context?, intent: Intent?) {
            //serviceBtn.text = "DONE!"
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)


        colorBack()


        single_btn.setOnClickListener {
            val intent = Intent(this, Singleplayer::class.java)
            intent.putExtra("color", colorChange)
            startActivity(intent)
        }
        score_btn.setOnClickListener {
            val intent = Intent(this, Score::class.java)
            intent.putExtra("color", colorChange)
            startActivity(intent)
        }
        custom_btn.setOnClickListener {
            val intent = Intent(this, CustomInput::class.java)
            intent.putExtra("color", colorChange)
            startActivity(intent)
        }
        two_btn.setOnClickListener {

            val intent = Intent(this, TwoGame::class.java)
            intent.putExtra("color", colorChange)
            startActivity(intent)

        }
        l_btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        r_btn.setOnClickListener {
            colorChange = 1
            colorBack()
        }
        b_btn.setOnClickListener {
            colorChange = 2
            colorBack()
        }
        ba_btn.setOnClickListener {
            colorChange = 3
            colorBack()
        }
    }

    fun colorBack(){
        when(colorChange){
            0 -> choice_layout.setBackgroundColor(Color.WHITE)
            1 -> choice_layout.setBackgroundColor(Color.RED)
            2 -> choice_layout.setBackgroundColor(Color.BLUE)
            3 -> choice_layout.setBackgroundColor(Color.BLACK)
        }
    }

    override fun onPause() {
        super.onPause()
        val j = Intent(this, MyIntentService::class.java)
        startService(j)

        //unregisterReceiver(receiver)
    }
}
