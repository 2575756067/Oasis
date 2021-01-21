package com.sprout

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView() {
        //todo 加载视频资源控件
        videoview!!.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.loginbackvideo));
        videoview.start() //todo 开始播放
        videoview.setOnCompletionListener { videoview.start() } //todo 循环播放
    }
}