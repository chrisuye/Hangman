package edu.towson.cosc431.christian.hangman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_singleplayer.*

class Singleplayer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singleplayer)

        fiveletter_btn.setOnClickListener {
            val intent = Intent(this, Singlegame::class.java)
            startActivity(intent)
        }
    }
}
