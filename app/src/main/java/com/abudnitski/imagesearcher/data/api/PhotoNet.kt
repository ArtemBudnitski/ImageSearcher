package com.abudnitski.imagesearcher.data.api

data class PhotoNet(
    val total: Int,
    val totalHits: Int,
    val hits: List<PhotoInfo>
)

data class PhotoInfo(
    val id: Int,
    val tags: String,
    val previewURL: String,
    val previewHeight: Int,
    val webformatURL: String,
    val webformatHeight: Int,
    val largeImageURL: String,
    val imageHeight: Int,
    val imageSize: Int,
    val views: Int,
    val downloads: Int,
    val likes: Int,
    val comments: Int,
    val user: String,
)
