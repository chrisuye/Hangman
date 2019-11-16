package edu.towson.cosc431.christian.hangman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




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

