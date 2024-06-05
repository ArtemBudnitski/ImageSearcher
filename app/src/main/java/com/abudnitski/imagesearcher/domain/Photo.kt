package com.abudnitski.imagesearcher.domain

data class Photo(
    val id: Int,
    val tags: String,
    val webformatURL: String,
    val largeImageURL: String,
    val views: Int,
    val downloads: Int,
    val likes: Int,
    val comments: Int,
    val user: String,
    val previewHeight: Int,
    val imageHeight: Int
)
