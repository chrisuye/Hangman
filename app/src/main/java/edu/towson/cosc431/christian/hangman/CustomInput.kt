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

            if (word_input.text.length <= 9 && word_input.text.length >= 1) {
                if (hintone.text.isNotEmpty() && hinttwo.text.isNotEmpty() && hintthree.text.isNotEmpty()){
                    val hint1 = hintone.text
                    val hint2 = hinttwo.text
                    val hint3 = hintthree.text
                    val word = word_input.text.toString()
                    hintone.setText("")
                    hinttwo.setText("")
                    hintthree.setText("")
                    word_input.setText("")
                    val intent = Intent(this, CustomGame::class.java)
                    intent.putExtra("Word", word)
                    intent.putExtra("Hint1", hint1)
                    intent.putExtra("Hint2", hint2)
                    intent.putExtra("HintT3", hint3)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"All three hints are needed", Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this,"Max of 9 letters", Toast.LENGTH_LONG).show()
            }
        }
    }
}
