package com.abudnitski.imagesearcher.domain

import com.abudnitski.imagesearcher.data.api.PhotoInfo
import com.abudnitski.imagesearcher.data.api.PhotoNet
import com.abudnitski.imagesearcher.data.db.PhotoEntity

class PhotoMapper {
    fun map(data: PhotoEntity): Photo {
        return Photo(
            id = data.id,
            tags = data.tags,
            webformatURL = data.webformatURL,
            largeImageURL = data.largeImageURL,
            views = data.views,
            downloads = data.downloads,
            likes = data.likes,
            comments = data.comments,
            user = data.user,
            previewHeight = data.previewHeight,
            imageHeight = data.imageHeight
        )
    }

    fun mapEntity(data: List<PhotoEntity>): List<Photo> {
        return data.map { map(it) }
    }

    private fun map(data: Photo, query: String): PhotoEntity {
        return PhotoEntity(
            id = data.id,
            tags = data.tags,
            webformatURL = data.webformatURL,
            largeImageURL = data.largeImageURL,
            views = data.views,
            downloads = data.downloads,
            likes = data.likes,
            comments = data.comments,
            user = data.user,
            imageHeight = data.imageHeight,
            previewHeight = data.previewHeight,
            query = query
        )
    }

    fun mapListOfPhoto(data: List<Photo>, query: String): List<PhotoEntity> {
        return data.map { map(it, query) }
    }

    private fun map(data: PhotoInfo): Photo {
        return Photo(
            id = data.id,
            tags = data.tags,
            webformatURL = data.webformatURL,
            largeImageURL = data.largeImageURL,
            views = data.views,
            downloads = data.downloads,
            likes = data.likes,
            comments = data.comments,
            user = data.user,
            previewHeight = data.previewHeight,
            imageHeight = data.imageHeight,
        )
    }

    private fun map(data: List<PhotoInfo>): List<Photo> {
        return data.map { map(it) }
    }


    fun mapNet(data: PhotoNet): List<Photo> {
        val hits = data.hits
        return map(hits)
    }

}