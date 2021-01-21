package com.sprout

import android.content.Intent
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.shop.base.BaseActivity
import com.sprout.databinding.ActivityMainBinding
import com.sprout.ui.discover.DiscoverFragment
import com.sprout.ui.home.HomeFragment
import com.sprout.ui.me.MeFragment
import com.sprout.ui.message.MessageFragment
import com.sprout.ui.more.MoreActivity
import com.sprout.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(
    R.layout.activity_main,
    MainViewModel::class.java
), View.OnClickListener {

    lateinit var homeFragment: HomeFragment
    lateinit var discoverFragment: DiscoverFragment
    lateinit var messageFragment: MessageFragment
    lateinit var meFragment: MeFragment
    var beginTransaction: FragmentTransaction? = null


    override fun initView() {
        //todo 初始化fragment
        homeFragment = HomeFragment()
        discoverFragment = DiscoverFragment()
        messageFragment = MessageFragment()
        meFragment = MeFragment()

        //todo 开启事物
        beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction!!.add(R.id.fragments, mViewModel.fragments.get(0))
            .add(R.id.fragments, mViewModel.fragments.get(1))
            .add(R.id.fragments, mViewModel.fragments.get(2))
            .add(R.id.fragments, mViewModel.fragments.get(3))
            .hide(mViewModel.fragments.get(1))
            .hide(mViewModel.fragments.get(2))
            .hide(mViewModel.fragments.get(3))

        beginTransaction!!.commit()


        mDataBinding.layoutHome.setOnClickListener(this)
        mDataBinding.layoutDiscover.setOnClickListener(this)
        mDataBinding.layoutMore.setOnClickListener(this)
        mDataBinding.layoutMessage.setOnClickListener(this)
        mDataBinding.layoutMe.setOnClickListener(this)
    }

    override fun initVM() {
    }

    override fun initData() {
    }

    override fun initVariable() {
    }

    override fun onClick(v: View?) {
        //todo  重置所有图片
        resetImg()
        val transaction = supportFragmentManager.beginTransaction()
        when (v!!.id) {
            //todo  主页
            R.id.layout_home -> {
                mDataBinding.ivHome.setImageResource(R.mipmap.main_nav_home_is)
                transaction!!.show(mViewModel.fragments.get(0))
                    .hide(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(3))

            }
            //todo  搜索
            R.id.layout_discover -> {
                mDataBinding.ivDiscover.setImageResource(R.mipmap.main_nav_discover_is)
                transaction!!.show(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(0))
                    .hide(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(3))
            }
            //todo  更多
            R.id.layout_more -> {
                intent = Intent(this, MoreActivity::class.java)
                startActivity(intent)
            }
            //todo  消息
            R.id.layout_message -> {
                mDataBinding.ivMessage.setImageResource(R.mipmap.main_nav_message_is)
                transaction!!.show(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(3))
            }
            //todo  我的
            R.id.layout_me -> {
                mDataBinding.ivMe.setImageResource(R.mipmap.main_nav_mine_is)
                transaction!!.show(mViewModel.fragments.get(3))
                    .hide(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(0))
            }
        }
        transaction!!.commit()
    }

    private fun resetImg() {
        //todo 设置图片
        mDataBinding.ivHome.setImageResource(R.mipmap.main_nav_home_not)
        mDataBinding.ivDiscover.setImageResource(R.mipmap.main_nav_discover_not)
        mDataBinding.ivMore.setImageResource(R.mipmap.main_nav_more)
        mDataBinding.ivMessage.setImageResource(R.mipmap.main_nav_message_not)
        mDataBinding.ivMe.setImageResource(R.mipmap.main_nav_mine_not)
    }


}