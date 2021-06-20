package com.example.kotlin1lesson4.model.playlist

import java.io.Serializable

data class PlayList(
    var kind: String,
    var etag: String,
    var items: List<Items>
) : Serializable

data class Thumbnails(
        var default: Default,
        var medium: Medium,
        var high: High
) : Serializable

data class Snippet(
        var publishedAt: String,
        var channelId: String,
        var title: String,
        var description: String,
        var thumbnails: Thumbnails,
        var channelTitle: String,
        var tags: List<String>,
        var categoryId: String,
        var liveBroadcastContent: String,
        var localized: Localized
) : Serializable

data class PageInfo(
        var totalResults: Int,
        var resultsPerPage: Int
) : Serializable

data class Medium(
        var url: String,
        var width: Int,
        var height: Int
) : Serializable

data class Localized(
        var title: String,
        var description: String
) : Serializable

data class Items(
        var kind: String,
        var etag: String,
        var id: String,
        var snippet: Snippet,
        var contentDetails: ContentDetails
) : Serializable

data class High(
        var url: String,
        var width: Int,
        var height: Int
) : Serializable

data class Default(
        var url: String,
        var width: Int,
        var height: Int
) : Serializable

data class ContentRating(
        val name: String = ""
) : Serializable

data class ContentDetails(
        var duration: String,
        var dimension: String,
        var definition: String,
        var caption: String,
        var licensedContent: Boolean,
        var contentRating: ContentRating,
        var projection: String,
        var itemCount: Int
) : Serializable
