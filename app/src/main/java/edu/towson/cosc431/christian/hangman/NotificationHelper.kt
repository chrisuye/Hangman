package edu.towson.cosc431.christian.hangman

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.content.ContextCompat

fun createNotificationChannel(ctx: Context, notificationId: String) {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "SERVICE_DEMO_CHANNEL"
        val descriptionText = "Notification channel for ServiceDemo"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(notificationId, name, importance).apply {
            description = descriptionText
        }

        val notificationManager =
            ContextCompat.getSystemService(ctx, NotificationManager::class.java)
        notificationManager?.createNotificationChannel(channel)
    }
}
