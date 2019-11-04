package edu.towson.cosc431.christian.hangman

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_background.*
import kotlinx.android.synthetic.main.activity_choice.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.activity_settings.*

class Background : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background)

        //recycleview.setBackgroundColor(Color.BLUE)

         red_btn.setOnClickListener{
            background_layout.setBackgroundColor(Color.RED)
            registration_layout.setBackgroundColor(Color.RED)
            login.setBackgroundColor(Color.RED)
            home_ll.setBackgroundColor(Color.RED)
            choice_layout.setBackgroundColor(Color.RED)
            settings_layout.setBackgroundColor(Color.RED)
            main_layout.setBackgroundColor(Color.RED)


        }
        blue_btn.setOnClickListener{
            background_layout.setBackgroundColor(Color.BLUE)
            registration_layout.setBackgroundColor(Color.BLUE)
            login.setBackgroundColor(Color.BLUE)
            home_ll.setBackgroundColor(Color.BLUE)
            choice_layout.setBackgroundColor(Color.BLUE)
            settings_layout.setBackgroundColor(Color.BLUE)
            main_layout.setBackgroundColor(Color.BLUE)


        }
        black_btn.setOnClickListener{
            background_layout.setBackgroundColor(Color.BLACK)
            registration_layout.setBackgroundColor(Color.BLACK)
            login.setBackgroundColor(Color.BLACK)
            home_ll.setBackgroundColor(Color.BLACK)
            choice_layout.setBackgroundColor(Color.BLACK)
            settings_layout.setBackgroundColor(Color.BLACK)
            main_layout.setBackgroundColor(Color.BLACK)


        }
    }
}
