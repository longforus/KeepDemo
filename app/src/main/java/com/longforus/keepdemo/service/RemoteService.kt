package com.longforus.keepdemo.service

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import android.os.IBinder

class RemoteService:Service(){
    override fun onBind(intent: Intent?): IBinder? {
        return LocalBinder()
    }

    inner class LocalBinder: Binder()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        bindService(Intent(this,LocalService::class.java),mCoon,Service.BIND_IMPORTANT)
        return super.onStartCommand(intent, flags, startId)
    }

    val mCoon = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {

        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            startService(Intent(this@RemoteService,LocalService::class.java))
        }

    }
}