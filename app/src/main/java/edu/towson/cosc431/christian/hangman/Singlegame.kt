package edu.towson.cosc431.christian.hangman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_singlegame.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class Singlegame : AppCompatActivity() {

    lateinit var handler: FiveLetter
    var list = ArrayList<Words>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singlegame)

        val intent = intent
        var urlname =
            "https://www.wordgamedictionary.com/word-lists/5-letter-words/5-letter-words.json"
        val numberletter = intent.getIntExtra("Letter",5)

        if (numberletter == 5){
            urlname =
                "https://www.wordgamedictionary.com/word-lists/5-letter-words/5-letter-words.json"
        }
        else if (numberletter == 7){
            urlname =
                "https://www.wordgamedictionary.com/word-lists/7-letter-words/7-letter-words.json"
        }
        else if (numberletter == 9){
            urlname =
                "https://www.wordgamedictionary.com/word-lists/9-letter-words/9-letter-words.json"
        }

        handler = FiveLetter(this)




        fetchjson(urlname)

        }

        private fun fetchjson(go:String?) {
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

            var i = 0

            while (i < jsonArray.length()) {

                val jsonObject = jsonArray.getJSONObject(i)
                list.add(
                    Words(
                        jsonObject.getString("word")
                    )
                )
                i++
            }
            println(list)
            val j = (0..list.size).random()
            println(list[j].word)

            word_text.text = list[j].word.toString()


        }
}

