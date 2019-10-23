package edu.towson.cosc431.christian.hangman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_singlegame.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class Singlegame : AppCompatActivity() {
    lateinit var handler:FiveLetter
    var list = ArrayList<Words>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singlegame)

        handler = FiveLetter(this)



        fetchjson()

        



    }
    private fun fetchjson(){
        println("hey it works")

        val url = "https://www.wordgamedictionary.com/word-lists/5-letter-words/5-letter-words.json"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("not tre")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                println(body)

                val word:String?

                word = body.toString()

                jsonparse(word)
            }

        })
    }
    fun jsonparse (jsonString:String?){

        val jsonArray = JSONArray(jsonString)

        var i =0

        while (i < jsonArray.length()){

            val jsonObject = jsonArray.getJSONObject(i)
            list.add(
                Words(
                    jsonObject.getString("word")
                )
            )
            i++
        }
        println(list)
        println(list[1].word)
        val j = (0..200).random()
        val word = list[j].word


        word_txt.text = "what the fuck"

        //handler.insertData("hello")
        /*while (j < 200){
            handler.insertData(list[j].word)
            println(list[j].word)
            j++
        }*/

    }
}
