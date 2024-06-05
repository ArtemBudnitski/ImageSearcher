package com.abudnitski.imagesearcher.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PhotoEntity(
    @PrimaryKey
    @ColumnInfo val id: Int,
    @ColumnInfo val tags: String,
//    @ColumnInfo val previewURL: String,
    @ColumnInfo val previewHeight: Int,
    @ColumnInfo val webformatURL: String,
//    @ColumnInfo val webformatHeight: Int,
    @ColumnInfo val largeImageURL: String,
    @ColumnInfo val imageHeight: Int,
//    @ColumnInfo val imageSize: Int,
    @ColumnInfo val views: Int,
    @ColumnInfo val downloads: Int,
    @ColumnInfo val likes: Int,
    @ColumnInfo val comments: Int,
    @ColumnInfo val user: String,
    @ColumnInfo val query: String,
)
