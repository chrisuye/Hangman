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

        //Change background
        val colorChange = intent.getIntExtra("color", 0)
        when(colorChange){
            0 -> custom_layout.setBackgroundColor(Color.WHITE)
            1 -> custom_layout.setBackgroundColor(Color.RED)
            2 -> custom_layout.setBackgroundColor(Color.BLUE)
            3 -> custom_layout.setBackgroundColor(Color.BLACK)
        }

        /*
        Input word for the game. the word will be converted to lower case and checked if it is more
        more than 4 letters. then the information will be passed through intent
         */

        start_btn.setOnClickListener {

            if (word_input.text.length >= 5) {

                val word = word_input.text.toString().toLowerCase()

                word_input.setText("")
                val intent2 = Intent(this, CustomGame::class.java)
                intent2.putExtra("Word", word)

                startActivity(intent2)

            }
            else{
                Toast.makeText(this,"Word must be at least 5 letters", Toast.LENGTH_LONG).show()
            }
        }
    }
}
