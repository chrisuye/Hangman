package edu.towson.cosc431.christian.hangman

import android.app.IntentService
import android.app.PendingIntent
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MyIntentService : IntentService("MyIntentService") {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel(this, NOTIF_CHANNEL_ID)
    }

    override fun onHandleIntent(intent: Intent?) {

        Thread.sleep(10000)
        showNotification()

    }

    private fun showNotification() {
        val intent = Intent(this,Choice::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)

        val builder = NotificationCompat.Builder(this, NOTIF_CHANNEL_ID)
            .setContentTitle("HangMan")
            .setContentText("Continue playing the game")
            .setSmallIcon(android.R.drawable.btn_default)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
        val notification = builder.build()

        NotificationManagerCompat.from(this)
            .notify(NOTIF_ID, notification)
    }

    private fun maybeCancelNotification() {
        if(application is MyApplication) {
            val app = application as MyApplication

            if(app.isChoiceActivityVisable){
                NotificationManagerCompat.from(this)
                    .cancel(NOTIF_ID)

                val intent = Intent(BROADCAST_ACTION)
                sendBroadcast(intent)
            }
        }
    }

    companion object {
        val NOTIF_CHANNEL_ID = "edu.towson.cosc431"
        val NOTIF_ID = 1
        val BROADCAST_ACTION = "edu.towson.cosc431.SERVICE_ACTION"
    }
}