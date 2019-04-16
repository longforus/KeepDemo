package com.longforus.keepdemo.keepactivity

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import java.lang.ref.WeakReference

class KeepActivity : Activity() {
val TAG = "KeepActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setGravity(Gravity.START or Gravity.TOP)
        val attributes = window.attributes
        attributes.width = 1
        attributes.height = 1
        attributes.x = 0
        attributes.y = 0
        window.attributes = attributes
        KeepManager.keepAct = WeakReference(this)
        Log.i(TAG, "onCreate ")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy ")
    }

}