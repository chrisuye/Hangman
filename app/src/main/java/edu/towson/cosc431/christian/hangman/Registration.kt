package edu.towson.cosc431.christian.hangman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*

class Registration : AppCompatActivity() {

    lateinit var handler:DatabaseHelper
    lateinit var handlerr:ScoreDatabase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        handler = DatabaseHelper(this)
        handlerr = ScoreDatabase(this)


        save.setOnClickListener{
            //Todo make sure that username and password is not null
            if (name.text.toString().isEmpty() || password_registration.text.toString().isEmpty()){
                Toast.makeText(this,"Missing username and/or password", Toast.LENGTH_SHORT).show()
            }
            else{
                //newplayer = Player(-1, name.text.toString(), password_registration.text.toString(), 0, 0)
                if (handler.userNamePresent(name.text.toString())) {
                    handler.insertUserData(name.text.toString(), password_registration.text.toString())
                    handlerr.insertScoreData(0,0)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

                else{
                    Toast.makeText(this,"Username exists", Toast.LENGTH_SHORT).show()
                }


            }
        }
    }
}
