package edu.towson.cosc431.christian.hangman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.towson.cosc431.christian.hangman.Interface.IGameRepo
import edu.towson.cosc431.christian.hangman.Interface.IWord
import kotlinx.android.synthetic.main.activity_singlegame.*
import kotlinx.android.synthetic.main.fragment_hangman_game.*
import kotlinx.android.synthetic.main.fragment_hangman_image.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class Singlegame : AppCompatActivity() {

    lateinit var gamecheck: IGameRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singlegame)

        val intent = intent

        val word = intent.getStringExtra("Word")


        gamecheck = GameRepo(this)



        var letters : String = ""
        var wordview = ""
        //val game = word.length
        val wordarry = word.toCharArray()

        for (elm in wordarry){
            wordview = wordview + "_"
        }

        word_view.text = wordview
        var wrongcount = 0

        try_btn.setOnClickListener {

            val guess = guess_input.text.toString()

            if (gamecheck.inputCount(guess)){

                if (gamecheck.letterUsed(guess, letters)){
                    letters = letters + guess + ","
                    showtry_view.text = letters

                    if (gamecheck.checkWord(guess, word)){
                        val wordviewarray = wordview.toCharArray()
                        var count = 0

                        for (elm in wordarry){
                            if (guess.equals(elm.toString())){

                                wordviewarray.set(count, elm)
                                wordview = ""

                                for (i in wordviewarray){
                                    wordview = wordview + i.toString()
                                }

                                word_view.text = wordview
                            }
                            count++

                        }

                    }
                    else {
                        wrongcount++
                        Toast.makeText(this, "Wrong letter", Toast.LENGTH_SHORT).show()
                        when(wrongcount){
                            1 -> imageView.setImageResource(R.drawable.one)
                            2 -> imageView.setImageResource(R.drawable.two)
                            3 -> imageView.setImageResource(R.drawable.three)
                            4 -> imageView.setImageResource(R.drawable.four)
                            5 -> imageView.setImageResource(R.drawable.five)
                            6 -> imageView.setImageResource(R.drawable.six)
                            7 -> imageView.setImageResource(R.drawable.seven)
                            8 -> imageView.setImageResource(R.drawable.eight)
                            9 -> imageView.setImageResource(R.drawable.nine)
                            10 -> imageView.setImageResource(R.drawable.ten)
                            11 -> imageView.setImageResource(R.drawable.eleven)
                            12 -> {
                                imageView.setImageResource(R.drawable.twelve)
                                Toast.makeText(this, "GAME OVER!!!!!", Toast.LENGTH_SHORT).show()
                            }

                        }
                    }

                }
                else{
                    Toast.makeText(this, "Letter already used", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Only One Letter", Toast.LENGTH_SHORT).show()
            }

            if (gamecheck.winGame(wordview)){
                Toast.makeText(this, "WINNER WINNER!!!!!!", Toast.LENGTH_SHORT).show()
            }

        }

    }


}

