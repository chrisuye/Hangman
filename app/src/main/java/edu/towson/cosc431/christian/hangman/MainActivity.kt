package edu.towson.cosc431.christian.hangman

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.background.*
import kotlinx.android.synthetic.main.choice.*
import kotlinx.android.synthetic.main.game_layout.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.settings.*
import kotlinx.android.synthetic.main.user_registration.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var handler:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = DatabaseHelper(this)

        showHome()

        registration.setOnClickListener{
            showRegistration()
        }
        login.setOnClickListener{
            showLogin()
        }
        save.setOnClickListener{
            handler.insertUserData(name.text.toString(),password_registration.text.toString())
            showHome()
        }
        login_button.setOnClickListener {
            if (handler.userPresent(login_name.text.toString(), login_password.text.toString())){
                Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()
                showChoice()
            }
            else
                Toast.makeText(this,"Login Fail",Toast.LENGTH_SHORT).show()

        }
        setting_btn.setOnClickListener {
            showSettings()
        }
        logout.setOnClickListener {
            showHome()
        }
        background_btn.setOnClickListener {
            showBackground()
        }
        red_btn.setOnClickListener{
            background_layout.setBackgroundColor(Color.RED)
            registration_layout.setBackgroundColor(Color.RED)
            login_layout.setBackgroundColor(Color.RED)
            home_ll.setBackgroundColor(Color.RED)
            choice_layout.setBackgroundColor(Color.RED)
            settings_layout.setBackgroundColor(Color.RED)
            main_layout.setBackgroundColor(Color.RED)
            showChoice()

        }
        blue_btn.setOnClickListener{
            background_layout.setBackgroundColor(Color.BLUE)
            registration_layout.setBackgroundColor(Color.BLUE)
            login_layout.setBackgroundColor(Color.BLUE)
            home_ll.setBackgroundColor(Color.BLUE)
            choice_layout.setBackgroundColor(Color.BLUE)
            settings_layout.setBackgroundColor(Color.BLUE)
            main_layout.setBackgroundColor(Color.BLUE)
            showChoice()

        }
        black_btn.setOnClickListener{
            background_layout.setBackgroundColor(Color.BLACK)
            registration_layout.setBackgroundColor(Color.BLACK)
            login_layout.setBackgroundColor(Color.BLACK)
            home_ll.setBackgroundColor(Color.BLACK)
            choice_layout.setBackgroundColor(Color.BLACK)
            settings_layout.setBackgroundColor(Color.BLACK)
            main_layout.setBackgroundColor(Color.BLACK)
            showChoice()

        }
        single_btn.setOnClickListener {
            showgame()
            fetchjson()
        }

    }

    private fun fetchjson(){
        println("hey it works")
        word.text = "hey"
        val url = "https://www.wordgamedictionary.com/word-lists/5-letter-words/5-letter-words.json"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("failed try the fuck again")
            }

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)




            }
        })
    }

    private fun showBackground() {
        registration_layout.visibility=View.GONE
        login_layout.visibility=View.GONE
        home_ll.visibility=View.GONE
        choice_layout.visibility=View.GONE
        settings_layout.visibility=View.GONE
        background_layout.visibility=View.VISIBLE
    }

    private fun showgame(){
        game_layout.visibility = View.VISIBLE
        registration_layout.visibility=View.GONE
        login_layout.visibility=View.GONE
        home_ll.visibility=View.GONE
        choice_layout.visibility=View.GONE
        settings_layout.visibility=View.GONE
        background_layout.visibility=View.GONE
    }


    private fun showRegistration(){
        game_layout.visibility = View.GONE
        registration_layout.visibility=View.VISIBLE
        login_layout.visibility=View.GONE
        home_ll.visibility=View.GONE
        choice_layout.visibility=View.GONE
        settings_layout.visibility=View.GONE
        background_layout.visibility=View.GONE
    }
    private fun showLogin(){
        game_layout.visibility = View.GONE
        registration_layout.visibility=View.GONE
        login_layout.visibility=View.VISIBLE
        home_ll.visibility=View.GONE
        choice_layout.visibility=View.GONE
        settings_layout.visibility=View.GONE
        background_layout.visibility=View.GONE
    }
    private fun showHome(){
        game_layout.visibility = View.GONE
        registration_layout.visibility=View.GONE
        login_layout.visibility=View.GONE
        home_ll.visibility=View.VISIBLE
        choice_layout.visibility=View.GONE
        settings_layout.visibility=View.GONE
        background_layout.visibility=View.GONE
    }
    private fun showChoice(){
        game_layout.visibility = View.GONE
        registration_layout.visibility=View.GONE
        login_layout.visibility=View.GONE
        home_ll.visibility=View.GONE
        choice_layout.visibility=View.VISIBLE
        settings_layout.visibility=View.GONE
        background_layout.visibility=View.GONE
    }
    private fun showSettings(){
        game_layout.visibility = View.GONE
        registration_layout.visibility=View.GONE
        login_layout.visibility=View.GONE
        home_ll.visibility=View.GONE
        choice_layout.visibility=View.GONE
        settings_layout.visibility=View.VISIBLE
        background_layout.visibility=View.GONE
    }
}

