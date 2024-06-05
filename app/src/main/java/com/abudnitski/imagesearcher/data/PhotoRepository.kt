package com.abudnitski.imagesearcher.data

import com.abudnitski.imagesearcher.data.api.ApiService
import com.abudnitski.imagesearcher.data.db.PhotoDao
import com.abudnitski.imagesearcher.domain.Photo
import com.abudnitski.imagesearcher.domain.PhotoMapper

class PhotoRepository(
    private val photoDao: PhotoDao,
    private val apiService: ApiService,
    private val photoMapper: PhotoMapper
) {

    suspend fun getAllPhotos(query: String): List<Photo> {
        return try {
            val netModels = apiService.getPhoto(query)
            val domainModels = photoMapper.mapNet(netModels)
            insertPhoto(domainModels, query)
            domainModels
        } catch (e: Exception) {
            val entityModels = photoDao.get(query)
            val domainModels = photoMapper.mapEntity(entityModels)
            domainModels
        }
    }

    suspend fun findPhoto(id: String): Photo {
        val data = photoDao.find(id = id)
        return photoMapper.map(data)
    }

    private suspend fun insertPhoto(data: List<Photo>, query: String) {
        val entityModels = photoMapper.mapListOfPhoto(data, query)
        photoDao.insertAll(*entityModels.toTypedArray())
    }
}