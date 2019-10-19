package edu.towson.cosc431.christian.hangman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {
    lateinit var handler:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        handler = DatabaseHelper(this)

        login_button.setOnClickListener {
            if (handler.userPresent(login_name.text.toString(), login_password.text.toString())){
                Toast.makeText(this,"Login Success", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, Choice::class.java)
                startActivity(intent)

            }
            else
                Toast.makeText(this,"Login Fail", Toast.LENGTH_SHORT).show()

        }
    }
}
