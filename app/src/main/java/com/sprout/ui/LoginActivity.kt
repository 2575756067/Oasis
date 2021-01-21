package com.sprout.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.basemvvm.utils.ToastUtils
import com.sprout.MainActivity
import com.sprout.R
import com.sprout.utils.CountDownTimerUtils
import kotlinx.android.synthetic.main.acticity_writelogin.*
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(), View.OnClickListener {


    private var mText1Tv: TextView? = null
    private var mText2Tv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView() {
        //todo 加载视频资源控件
        videoview!!.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.login_bg));
        videoview.start() //todo 开始播放
        videoview.setOnCompletionListener { videoview.start() } //todo 循环播放

        mText1Tv = findViewById(R.id.tv_text1) as TextView      //todo 登录表示您已阅读并同意
        mText2Tv = findViewById(R.id.tv_text2) as TextView      //todo 中国移动认证服务条款

        iv_qq.setOnClickListener(View.OnClickListener {
            ToastUtils.s(this, "点击了qq")
        })
        iv_wb.setOnClickListener(View.OnClickListener {
            ToastUtils.s(this, "点击了微博")
        })

        iv_wx.setOnClickListener(View.OnClickListener {
            ToastUtils.s(this, "点击了微信")
        })

        iv_apple.setOnClickListener(View.OnClickListener {
            ToastUtils.s(this, "点击了apple")
        })

        otherLogin() //todo 其他电话号码登录
        Login()        //todo 本机号码一键登录

        LoginCode()        // TODO: 2021/1/21  点击获取短信验证码弹出验证码框

    }

    // TODO: 2021/1/21  点击获取短信验证码弹出验证码框
    private fun LoginCode() {
        btn_verify.setOnClickListener(View.OnClickListener {
            cl_loginverify.visibility = View.VISIBLE

            if (!TextUtils.isEmpty(et_login.text)) {
                splitEditText.visibility = View.VISIBLE
                if (et_login.text.length == 11) {
                    //发送验证码
                    val mCountDownTimerUtils =
                        CountDownTimerUtils(btn_verify, 60000, 1000)
                    mCountDownTimerUtils.start()
                } else {
                    ToastUtils.s(this, "手机号必须等于11位")
                }
            } else {
                ToastUtils.s(this, "手机号不能为空")
            }

        })
    }

    //todo 本机号码一键登录
    private fun Login() {
        btn_login.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        })
    }

    //todo 其他电话号码登录
    private fun otherLogin() {
        tv_otherlogin.setOnClickListener(View.OnClickListener {
            //todo 隐藏电话
            ll_login.visibility = View.GONE
            //todo 显示其他号码登录
            cl_loginverify.visibility = View.VISIBLE
        })
    }

    override fun onClick(v: View?) {

    }

    override fun onRestart() {
        super.onRestart()
        initView() //todo 重新跑
    }
}