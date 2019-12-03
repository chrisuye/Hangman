package edu.towson.cosc431.christian.hangman

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*

class Registration : AppCompatActivity() {

    lateinit var handler:UserDataBase
    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationManager: NotificationManager
    lateinit var builder:Notification.Builder
    private val channelId = "edu.towson.cosc431.christian.hangman"
    private val description = "Welcome new player"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        handler = UserDataBase(this)

        save.setOnClickListener{


            if (name.text.toString().isEmpty() || password_registration.text.toString().isEmpty()){
                Toast.makeText(this,"Missing username and/or password", Toast.LENGTH_SHORT).show()
            }
            else{

                if (handler.userNamePresent(name.text.toString())) {
                    handler.insertUserData(name.text.toString(), password_registration.text.toString())

                    val intent = Intent(this, Choice::class.java)
                    //val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
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
                            .setContentText("Welcome "+name.text)
                            .setSmallIcon(R.drawable.ic_launcher_round)
                            .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher))
                            //.setContentIntent(pendingIntent)
                    }else{
                        builder = Notification.Builder(this)
                            .setContentTitle("HangMan")
                            .setContentText("Welcome " +name.text)
                            .setSmallIcon(R.drawable.ic_launcher_round)
                            .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher))
                            //.setContentIntent(pendingIntent)
                    }

                    notificationManager.notify(1234, builder.build())


                }

                else{
                    Toast.makeText(this,"Username exists", Toast.LENGTH_SHORT).show()
                }


            }

        }
    }
}
