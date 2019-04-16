package com.longforus.keepdemo.service

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat

class ForegroundService : Service() {

    companion object {
        const val SERVICE_ID = 130
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    @SuppressLint("NewApi")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when {
            Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2 -> {
                startForeground(SERVICE_ID, Notification())
            }
            Build.VERSION.SDK_INT < Build.VERSION_CODES.O -> {
                startForeground(SERVICE_ID, Notification())
                startService(Intent(this, InnerService::class.java))
            }
            else->{
                val notifyManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val channel = NotificationChannel("longforus", "void", NotificationManager.IMPORTANCE_MIN)
                notifyManager.createNotificationChannel(channel)
                val notification = NotificationCompat.Builder(this, "longforus").build()
                startForeground(SERVICE_ID,notification)
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    class InnerService : Service() {
        override fun onBind(intent: Intent?): IBinder? {
            return null
        }

        override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
            startForeground(SERVICE_ID, Notification())
            stopForeground(true)
            stopSelf()
            return super.onStartCommand(intent, flags, startId)
        }
    }
}