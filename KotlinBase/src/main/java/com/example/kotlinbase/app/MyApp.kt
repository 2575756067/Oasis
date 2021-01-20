package com.example.kotlinbase.app

import android.app.Application
import com.example.basemvvm.utils.MyMmkv

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        app = this
        map = HashMap()
        MyMmkv.initMMKV()
    }

    companion object {
        var instance: MyApp? = null

        @JvmField
        var app: MyApp? = null

        @JvmStatic
        var map: HashMap<String, Any>? = null
    }

}