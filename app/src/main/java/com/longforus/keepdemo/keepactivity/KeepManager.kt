package com.longforus.keepdemo.keepactivity

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import java.lang.ref.WeakReference

object KeepManager {
    var keepReceiver: KeepReceiver? = null
    var keepAct: WeakReference<KeepActivity>? = null
    private val filter = IntentFilter()

    init {
        filter.addAction(Intent.ACTION_SCREEN_OFF)
        filter.addAction(Intent.ACTION_SCREEN_ON)
    }

    fun register(context: Context) {
        keepReceiver = KeepReceiver()
        context.registerReceiver(keepReceiver, filter)
    }

    fun unregister(context: Context) {
        keepReceiver?.apply {
            context.unregisterReceiver(this)
        }
    }

    fun startKeep(context: Context) {
        val intent = Intent(context, KeepActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }


    fun stopKeep() {
        keepAct?.get()?.finish()
        keepAct = null
    }

}