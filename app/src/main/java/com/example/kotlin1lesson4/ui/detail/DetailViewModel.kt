package com.example.kotlin1lesson4.ui.detail

import androidx.lifecycle.MutableLiveData
import com.example.kotlin1lesson4.BuildConfig.API_KEY
import com.example.kotlin1lesson4.`object`.Constants
import com.example.kotlin1lesson4.base.BaseViewModel
import com.example.kotlin1lesson4.model.playlistItems.PlayListItems
import com.example.kotlin1lesson4.network.RetrofitClient
import com.example.kotlin1lesson4.network.YouTubeApi
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class DetailViewModel : BaseViewModel() {

    private var youTubeApi : YouTubeApi = RetrofitClient.create()

    fun fetchItemPlayList(id : String): MutableLiveData<PlayListItems?> {
        return fetchYoutubeApiPlayList(id)
    }

    private  fun fetchYoutubeApiPlayList(id: String): MutableLiveData<PlayListItems?> {

        val data = MutableLiveData<PlayListItems?>()

        youTubeApi.fetchPlaylistItems(Constants.PART, id, API_KEY)
            .enqueue(object : Callback<PlayListItems> {
                override fun onFailure(call: Call<PlayListItems>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<PlayListItems>,
                    response: Response<PlayListItems>
                ) {
                    data.value = response.body()
                }
            })
        return data
    }
}