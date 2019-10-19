package edu.towson.cosc431.christian.hangman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registration.*

class Registration : AppCompatActivity() {

    lateinit var handler:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        handler = DatabaseHelper(this)

        save.setOnClickListener{
            handler.insertUserData(name.text.toString(),password_registration.text.toString())
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}
