package com.longforus.keepdemo.keepactivity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class KeepReceiver:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_SCREEN_OFF->{
                KeepManager.startKeep(context!!)
            }
            Intent.ACTION_SCREEN_ON->{
                KeepManager.stopKeep()
            }
        }
    }
}