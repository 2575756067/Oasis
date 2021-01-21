package com.sprout.viewmodel.homefragment

import androidx.fragment.app.Fragment
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import com.sprout.ui.home.guanzhu.AttentionFragment
import com.sprout.ui.home.tongcheng.CityWideFragment
import com.sprout.ui.home.tuijian.RecommendFragment

class HomeFragmentViewModel : BaseViewModel(Injection.repository) {

    var fragments: MutableList<Fragment> = mutableListOf()

    init {
        fragments.add(CityWideFragment())
        fragments.add(AttentionFragment())
        fragments.add(RecommendFragment())
    }
}