package com.sprout.viewmodel

import androidx.fragment.app.Fragment
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import com.sprout.ui.discover.DiscoverFragment
import com.sprout.ui.home.HomeFragment
import com.sprout.ui.me.MeFragment
import com.sprout.ui.message.MessageFragment

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