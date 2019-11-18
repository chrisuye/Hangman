package edu.towson.cosc431.christian.hangman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_custom_input.*

class CustomInput : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_input)

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
