package edu.towson.cosc431.christian.hangman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_hangman_game.*

class CustomGame : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_game)

        var count = 0
        var flag = true

        val intent = intent
        val word = intent.getStringExtra("Word")
        println(word)
        var letters : String = ""
        var wordview = ""
        val game = word.length
        val wordarry = word.toCharArray()

        for (elm in wordarry){
            wordview = wordview + "_"
        }

        word_view.text = wordview

        try_btn.setOnClickListener {
            flag = true
            count = 0
            val guess = guess_input.text.toString()
            if (guess.length == 1){
                letters= letters + guess + ", "
                showtry_view.text = letters

                for (elm in wordarry){
                    if (guess.equals(elm.toString())){
                        flag = false
                        val wordviewarray = wordview.toCharArray()
                        wordviewarray.set(count, elm)
                        wordview = ""

                        for (i in wordviewarray){
                            wordview = wordview + i.toString()
                        }

                        word_view.text = wordview
                        if (count == game){
                            Toast.makeText(this, "You have won!!!", Toast.LENGTH_LONG).show()
                        }
                        break
                    }
                    if (flag){
                        Toast.makeText(this, "Wrong letter", Toast.LENGTH_LONG).show()
                    }
                    count++
                }

            }
            else{
                Toast.makeText(this, "ONLY ONE LETTER!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
