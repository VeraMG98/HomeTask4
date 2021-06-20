package com.example.kotlin1lesson4.network

import com.example.kotlin1lesson4.model.playlist.PlayList
import com.example.kotlin1lesson4.model.playlistItems.PlayListItems
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {
    @GET("playlists")
    fun fetchAllPlayLists(
        @Query("part") part : String,
        @Query("channelId") channelId : String,
        @Query("key") apiKty : String
    ) : Call<PlayList>

    @GET("playlistItems")
    fun fetchPlaylistItems(
        @Query("part") part: String,
        @Query("playlistId") playlistId: String,
        @Query("key") apiKey: String
    ): Call<PlayListItems>
}