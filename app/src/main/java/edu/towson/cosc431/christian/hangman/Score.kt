package edu.towson.cosc431.christian.hangman

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_score.*

class Score : AppCompatActivity() {

    /*
    show score by connecting to the data base and populating the recycler view
     */


    lateinit var handler:UserDataBase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        handler = UserDataBase(this)

        val intent = intent
        val colorChange = intent.getIntExtra("color",0)

        when(colorChange){
            1 -> score_layout.setBackgroundColor(Color.RED)
            2 -> score_layout.setBackgroundColor(Color.BLUE)
            3 -> score_layout.setBackgroundColor(Color.BLACK)
            0 -> score_layout.setBackgroundColor(Color.WHITE)
        }

        viewScore()



    }

    private fun viewScore(){
        val namelist:ArrayList<Table> = handler.getName()
        recycleview.layoutManager = LinearLayoutManager(this)
        recycleview.adapter = MainAdapter(namelist)
    }
}
