package com.sprout.viewmodel

import androidx.fragment.app.Fragment
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import com.sprout.discover.DiscoverFragment
import com.sprout.home.HomeFragment
import com.sprout.me.MeFragment
import com.sprout.message.MessageFragment

class MainViewModel : BaseViewModel(Injection.repository) {
    var fragments: MutableList<Fragment> = mutableListOf()

    //todo 添加到fragment 集合
    init {
        fragments.add(HomeFragment())
        fragments.add(DiscoverFragment())
        fragments.add(MessageFragment())
        fragments.add(MeFragment())
    }
}