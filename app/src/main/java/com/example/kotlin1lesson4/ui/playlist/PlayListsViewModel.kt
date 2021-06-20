package com.example.kotlin1lesson4.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin1lesson4.BuildConfig.API_KEY
import com.example.kotlin1lesson4.`object`.Constants
import com.example.kotlin1lesson4.base.BaseViewModel
import com.example.kotlin1lesson4.model.playlist.PlayList
import com.example.kotlin1lesson4.network.RetrofitClient
import com.example.kotlin1lesson4.network.YouTubeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayListsViewModel : BaseViewModel() {

    private var youTubeApi : YouTubeApi = RetrofitClient.create()

    fun fetchAllPlayLists() : LiveData<PlayList?> {
        return fetchYoyTubeApiPlayList()
    }

    private fun fetchYoyTubeApiPlayList(): LiveData<PlayList?> {
        val data = MutableLiveData<PlayList?>()
        youTubeApi.fetchAllPlayLists(Constants.PART, Constants.CHANNEL_ID, API_KEY)
            .enqueue(object : Callback<PlayList> {
                override fun onFailure(call: Call<PlayList>, t: Throwable) {}

                override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

            })
        return data
    }
}