package edu.towson.cosc431.christian.hangman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choice.*

class Choice : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        setting_btn.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }
        single_btn.setOnClickListener {
            val intent = Intent(this, Singleplayer::class.java)
            startActivity(intent)
        }
        score_btn.setOnClickListener {
            val intent = Intent(this, Score::class.java)
            startActivity(intent)
        }
        custom_btn.setOnClickListener {
            val intent = Intent(this, CustomInput::class.java)
            startActivity(intent)
        }
    }
}
