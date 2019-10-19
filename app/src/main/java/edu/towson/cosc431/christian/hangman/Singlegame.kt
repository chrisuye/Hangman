package edu.towson.cosc431.christian.hangman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_singlegame.*
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class Singlegame : AppCompatActivity() {
    lateinit var handler:FiveLetter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singlegame)

        handler = FiveLetter(this)

        fetchjson()


    }
    private fun fetchjson(){
        println("hey it works")
        word.text = "hey"
        val url = "https://www.wordgamedictionary.com/word-lists/5-letter-words/5-letter-words.json"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("failed ")
            }

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                jsonparse(body)

            }
        })
    }
    private fun jsonparse (jsonString:String?){

        val jsonArray = JSONArray(jsonString)
        val list = ArrayList<Words>()
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
        var j = 0
        while (j < list.size){
            handler.insertData(list[j].word)
            println(list[j].word)
            j++
        }

    }
}
