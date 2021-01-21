package com.sprout.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.kotlinbase.bean.Local_ChannelBean
import com.sprout.ui.home.tuijian.RecommendInfoFragment

class RecommendVpAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm){

    private var arrayList = ArrayList<RecommendInfoFragment>()
    private var Local_channel = ArrayList<Local_ChannelBean>()

    fun addList(arrayList:ArrayList<RecommendInfoFragment>,LocalList:ArrayList<Local_ChannelBean>){
        this.arrayList = arrayList
        this.Local_channel = LocalList
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment {
        return arrayList[position]
    }

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return Local_channel[position].name
    }
}