package com.sprout.ui.home.tuijian

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.kotlinbase.bean.Local_ChannelBean
import com.shop.base.BaseFragment
import com.sprout.R
import com.sprout.adapter.RecommendVpAdapter
import com.sprout.databinding.FragmentRecommendBinding
import com.sprout.viewmodel.recommend.RecommendViewModel
import kotlinx.android.synthetic.main.fragment_recommend.*

class RecommendFragment : BaseFragment<RecommendViewModel, FragmentRecommendBinding>(
    R.layout.fragment_recommend,
    RecommendViewModel::class.java
) {

    override fun initView() {
        //禁止滑动
        recommend_vp!!.setScanScroll(false)
    }

    override fun initVM() {

        val fragments = ArrayList<RecommendInfoFragment>()
        mViewModel.Local_Channel.observe(this, Observer { LocalList ->
            for (i in LocalList.indices) {
                var localInfoFragment = RecommendInfoFragment()
                fragments.add(localInfoFragment)
            }

            var recommendVpAdapter = RecommendVpAdapter(childFragmentManager)
            recommend_vp.adapter = recommendVpAdapter
            recommendVpAdapter.addList(fragments, LocalList as ArrayList<Local_ChannelBean>)
            recommend_tab.setupWithViewPager(recommend_vp)
        })
    }

    override fun initData() {
        mViewModel.getLocal_Channel()
    }

    override fun initVariable() {
    }


}