package com.sprout.viewmodel.recommend

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kotlinbase.bean.Local_ChannelBean
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import kotlinx.coroutines.launch

class RecommendViewModel : BaseViewModel(Injection.repository) {

    var Local_Channel: MutableLiveData<List<Local_ChannelBean>> = MutableLiveData()

    fun getLocal_Channel() {
        //TODO 调用数据仓库需要协程产生一个联系
        viewModelScope.launch {
            var result = repository.getLocal_Channel()

            if (result.errno == 0) {
                Local_Channel.postValue(result.data)
                Log.e("TAG", result.data.toString())
            } else {
                Log.e("TAG", "MeUserInfo: " + result.errmsg)
            }
        }
    }

}