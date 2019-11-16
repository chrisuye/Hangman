package edu.towson.cosc431.christian.hangman

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {

    lateinit var handler:UserDataBase

    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationManager: NotificationManager
    lateinit var builder: Notification.Builder
    private val channelId = "edu.towson.cosc431.christian.hangman"
    private val description = "Welcome Back player"


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        handler = UserDataBase(this)


        login_button.setOnClickListener {


            if (handler.userPresent(login_name.text.toString(), login_password.text.toString())){
                Toast.makeText(this,"Login Success", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, Choice::class.java)
                startActivity(intent)

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    notificationChannel =
                        NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                    notificationChannel.enableLights(true)
                    notificationChannel.lightColor = Color.GREEN
                    notificationChannel.enableVibration(true)
                    notificationManager.createNotificationChannel(notificationChannel)

                    builder = Notification.Builder(this, channelId)
                        .setContentTitle("HangMan")
                        .setContentText("Welcome back "+login_name.text)
                        .setSmallIcon(R.drawable.ic_launcher_round)
                        .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher))

                }else{
                    builder = Notification.Builder(this)
                        .setContentTitle("HangMan")
                        .setContentText("Welcome back player")
                        .setSmallIcon(R.drawable.ic_launcher_round)
                        .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher))

                }

                notificationManager.notify(12345, builder.build())

            }

            else
                Toast.makeText(this,"Login Fail", Toast.LENGTH_SHORT).show()


        }
    }
}
