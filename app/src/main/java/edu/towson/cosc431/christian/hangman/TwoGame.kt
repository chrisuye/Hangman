package edu.towson.cosc431.christian.hangman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_singleplayer.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class TwoGame : AppCompatActivity() {

    var list = ArrayList<Words>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_game)


        val urlarry = arrayOf("https://www.wordgamedictionary.com/word-lists/5-letter-words/5-letter-words.json",
            "https://www.wordgamedictionary.com/word-lists/7-letter-words/7-letter-words.json",
            "https://www.wordgamedictionary.com/word-lists/9-letter-words/9-letter-words.json")

        var select = 0



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

        var wol:String = ""

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

        //Todo fix the problem with getting the world

        val jsonArray = JSONArray(jsonString)

        var i = 0

        while (i < 200) {

            val jsonObject = jsonArray.getJSONObject(i)
            list.add(
                Words(
                    jsonObject.getString("word")
                )
            )
            /* wordhandler.addWord(Words(
                 jsonObject.getString("word")
             ), select)*/
            i++
        }
        // println(wordhandler.getWord(select))
        val j = (0..list.size).random()
        println("wwww wwwwwwwww "+list[j].word)
        //return list[j].word

        if (list[j].word.isNotEmpty()) {
            val intent = Intent(this, TwoPlayer::class.java)
            intent.putExtra("Word", list[j].word)
            startActivity(intent)
        }

        //word_text.text = wordhandler.getWord()



    }
}
