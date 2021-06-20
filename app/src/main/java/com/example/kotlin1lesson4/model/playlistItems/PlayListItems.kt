package com.example.kotlin1lesson4.model.playlistItems

import com.example.kotlin1lesson4.model.playlist.ContentDetails
import com.example.kotlin1lesson4.model.playlist.Default
import com.example.kotlin1lesson4.model.playlist.High
import com.example.kotlin1lesson4.model.playlist.Items
import com.example.kotlin1lesson4.model.playlist.Medium
import com.example.kotlin1lesson4.model.playlist.PageInfo
import com.example.kotlin1lesson4.model.playlist.Snippet
import com.example.kotlin1lesson4.model.playlist.Thumbnails
import java.io.Serializable

data class ContentDetails (
    var videoId : String,
    var videoPublishedAt : String
) : Serializable

data class Default (
    var url : String,
    var width : Int,
    var height : Int
) : Serializable

data class High (
    var url : String,
    var width : Int,
    var height : Int
) : Serializable

data class Items (
    var kind : String,
    var etag : String,
    var id : String,
    var snippet : Snippet,
    var contentDetails : ContentDetails
) : Serializable

data class Maxres (
    var url : String,
    var width : Int,
    var height : Int
) : Serializable

data class Medium (
    var url : String,
    var width : Int,
    var height : Int
) : Serializable

data class PageInfo (
    var totalResults : Int,
    var resultsPerPage : Int
) : Serializable

data class PlayListItems (
    var kind : String,
    var etag : String,
    var items : List<Items>,
    var pageInfo : PageInfo
) : Serializable

data class ResourceId (
    var kind : String,
    var videoId : String
) : Serializable

data class Snippet (
    var publishedAt : String,
    var channelId : String,
    var title : String,
    var description : String,
    var thumbnails : Thumbnails,
    var channelTitle : String,
    var playlistId : String,
    var position : Int,
    var resourceId : ResourceId,
    var videoOwnerChannelTitle : String,
    var videoOwnerChannelId : String
) : Serializable

data class Standard (
    var url : String,
    var width : Int,
    var height : Int
) : Serializable

data class Thumbnails (
    var default : Default,
    var medium : Medium,
    var high : High,
    var standard : Standard,
    var maxres : Maxres
) : Serializable