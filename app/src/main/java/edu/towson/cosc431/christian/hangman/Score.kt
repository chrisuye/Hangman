package edu.towson.cosc431.christian.hangman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_score.*

class Score : AppCompatActivity() {


    lateinit var handler:UserDataBase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        handler = UserDataBase(this)

        viewScore()



    }

    private fun viewScore(){
        val namelist:ArrayList<Table> = handler.getName()
        recycleview.layoutManager = LinearLayoutManager(this)
        recycleview.adapter = MainAdapter(namelist)
    }
}
