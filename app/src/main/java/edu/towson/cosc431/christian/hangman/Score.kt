package edu.towson.cosc431.christian.hangman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_score.*

class Score : AppCompatActivity() {

    lateinit var handler:DatabaseHelper
    lateinit var handelerr:ScoreDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        handler = DatabaseHelper(this)
        handelerr = ScoreDatabase(this)
        viewScore()


    }

    private fun viewScore(){
        val namelist:ArrayList<Table> = handler.getName()
        val scorelist:ArrayList<ScoreTable> = handelerr.getScore()
        recycleview.layoutManager = LinearLayoutManager(this)
        recycleview.adapter = MainAdapter(namelist, scorelist)
    }
}
