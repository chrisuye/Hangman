package edu.towson.cosc431.christian.hangman

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_choice.*
import kotlinx.android.synthetic.main.activity_custom_input.*

class CustomInput : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_input)

        val intent = intent
        val colorChange = intent.getIntExtra("color", 0)
        when(colorChange){
            0 -> custom_layout.setBackgroundColor(Color.WHITE)
            1 -> custom_layout.setBackgroundColor(Color.RED)
            2 -> custom_layout.setBackgroundColor(Color.BLUE)
            3 -> custom_layout.setBackgroundColor(Color.BLACK)
        }

        start_btn.setOnClickListener {

            if (word_input.text.length >= 5) {

                val word = word_input.text.toString()

                word_input.setText("")
                val intent = Intent(this, CustomGame::class.java)
                intent.putExtra("Word", word)

                startActivity(intent)

            }
            else{
                Toast.makeText(this,"Word must be at least 5 letters", Toast.LENGTH_LONG).show()
            }
        }
    }
}
