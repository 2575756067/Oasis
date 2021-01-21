package com.sprout.ui.home

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.shop.base.BaseFragment
import com.sprout.R
import com.sprout.databinding.HomeFragmentBinding
import com.sprout.ui.home.guanzhu.AttentionFragment
import com.sprout.ui.home.tongcheng.CityWideFragment
import com.sprout.ui.home.tuijian.RecommendFragment
import com.sprout.viewmodel.homefragment.HomeFragmentViewModel
import kotlinx.android.synthetic.main.home_fragment.*


class HomeFragment : BaseFragment<HomeFragmentViewModel, HomeFragmentBinding>(
    R.layout.home_fragment,
    HomeFragmentViewModel::class.java
), View.OnClickListener {

    lateinit var attentionFragment: AttentionFragment
    lateinit var cityWideFragment: CityWideFragment
    lateinit var recommendFragment: RecommendFragment
    var beginTransaction: FragmentTransaction? = null


    override fun initView() {
        // TODO: 2021/1/21  初始化fragment
        cityWideFragment = CityWideFragment()
        attentionFragment = AttentionFragment()
        recommendFragment = RecommendFragment()

        //todo 开启事物
        beginTransaction = childFragmentManager.beginTransaction()
        beginTransaction!!.add(R.id.homefragment_fragments, mViewModel.fragments.get(0))
            .add(R.id.homefragment_fragments, mViewModel.fragments.get(1))
            .add(R.id.homefragment_fragments, mViewModel.fragments.get(2))
            .hide(mViewModel.fragments.get(1))
            .hide(mViewModel.fragments.get(2))

        beginTransaction!!.commit()

        mDataBinding.layoutNearby.setOnClickListener(this)
        mDataBinding.layoutFollow.setOnClickListener(this)
        mDataBinding.layoutRecommend.setOnClickListener(this)
    }

    override fun initVM() {
    }

    override fun initData() {
    }

    override fun initVariable() {
    }

    override fun onClick(v: View?) {
        resetImg()

        val transaction = childFragmentManager.beginTransaction()
        when (v?.id) {
            //todo  同城
            R.id.layout_nearby -> {
                mDataBinding.ivNearby.setImageResource(R.mipmap.tab_nearby_highlight)
                view1.visibility = View.VISIBLE
                transaction!!.show(mViewModel.fragments.get(0))
                    .hide(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(2))
            }
            //todo  关注
            R.id.layout_follow -> {
                view2.visibility = View.VISIBLE

                mDataBinding.ivFollow.setImageResource(R.mipmap.tab_follow_highlight)
                transaction!!.show(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(0))
                    .hide(mViewModel.fragments.get(2))
            }
            //todo  推荐
            R.id.layout_recommend -> {
                view3.visibility = View.VISIBLE
                mDataBinding.ivRecommend.setImageResource(R.mipmap.tab_recommend_highlight)
                transaction!!.show(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(1))
            }
        }
        transaction.commit()
    }

    private fun resetImg() {
        //todo 设置图片
        mDataBinding.ivNearby.setImageResource(R.mipmap.tab_nearby)
        mDataBinding.ivFollow.setImageResource(R.mipmap.tab_follow)
        mDataBinding.ivRecommend.setImageResource(R.mipmap.tab_recommend)
        view1.visibility = View.GONE
        view2.visibility = View.GONE
        view3.visibility = View.GONE
    }


}