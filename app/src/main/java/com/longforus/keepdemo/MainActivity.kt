package com.longforus.keepdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.longforus.keepdemo.service.LocalService
import com.longforus.keepdemo.service.RemoteService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //1px
//        KeepManager.register(this)

//前台服务
//        startService(Intent(this,ForegroundService::class.java))
        //双进程
        startService(Intent(this,LocalService::class.java))
        startService(Intent(this,RemoteService::class.java))
    }

    override fun onDestroy() {
        super.onDestroy()
//        KeepManager.unregister(this)
    }
}
