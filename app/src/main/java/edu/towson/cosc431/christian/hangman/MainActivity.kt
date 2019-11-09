package edu.towson.cosc431.christian.hangman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.towson.cosc431.christian.hangman.Interface.IWord
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_hangman_game.*
import kotlinx.android.synthetic.main.fragment_hangman_image.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class MainActivity : AppCompatActivity() {

    //lateinit var wordhandler: IWord


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //wordhandler = WordRepo()


        /*val urlarry = arrayOf("https://www.wordgamedictionary.com/word-lists/5-letter-words/5-letter-words.json",
        "https://www.wordgamedictionary.com/word-lists/7-letter-words/7-letter-words.json",
        "https://www.wordgamedictionary.com/word-lists/9-letter-words/9-letter-words.json")

        var select = 0

        wordhandler.clear()

        for (i in urlarry){
            fetchjson(i, 0)
            select++
        }*/





        registration.setOnClickListener{
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }
        login.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)



        }


    }


}

