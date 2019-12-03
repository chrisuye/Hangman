package edu.towson.cosc431.christian.hangman

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choice.*
import kotlinx.android.synthetic.main.activity_singleplayer.*
import kotlinx.android.synthetic.main.activity_singleplayer.fiveletter_btn
import kotlinx.android.synthetic.main.activity_singleplayer.nineletter_btn
import kotlinx.android.synthetic.main.activity_singleplayer.sevenletter_btn
import kotlinx.android.synthetic.main.activity_two_game.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class TwoGame : AppCompatActivity() {

    var list = ArrayList<Words>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_game)

        val intent = intent
        val colorChange = intent.getIntExtra("color", 0)

        when(colorChange){
            0 -> two_layout.setBackgroundColor(Color.WHITE)
            1 -> two_layout.setBackgroundColor(Color.RED)
            2 -> two_layout.setBackgroundColor(Color.BLUE)
            3 -> two_layout.setBackgroundColor(Color.BLACK)
        }


        val urlarry = arrayOf("https://www.wordgamedictionary.com/word-lists/5-letter-words/5-letter-words.json",
            "https://www.wordgamedictionary.com/word-lists/7-letter-words/7-letter-words.json",
            "https://www.wordgamedictionary.com/word-lists/9-letter-words/9-letter-words.json")



        fiveletter_btn.setOnClickListener {
            list.clear()
            fetchjson(urlarry[0])

        }
        sevenletter_btn.setOnClickListener {
            list.clear()
            fetchjson(urlarry[1])

        }
        nineletter_btn.setOnClickListener {
            list.clear()
            fetchjson(urlarry[2])

        }
    }

    fun fetchjson(go:String?) {
        println("hey it works")


        val url = go

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("not tre")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                println(body)

                val word: String?

                word = body.toString()

                jsonparse(word)
            }

        })


    }


    fun jsonparse(jsonString: String?) {

        val jsonArray = JSONArray(jsonString)
        val words:String
        val range = jsonArray.length() -1

        val rand = (0..range).random()
        words = jsonArray.getJSONObject(rand).getString("word")

        if (words.isNotEmpty()) {
            val intent = Intent(this, TwoPlayer::class.java)
            intent.putExtra("Word", words)
            startActivity(intent)
        }

    }
}
