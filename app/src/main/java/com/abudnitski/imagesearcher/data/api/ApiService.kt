package com.abudnitski.imagesearcher.data.api

import retrofit2.http.GET
import retrofit2.http.Query

const val KEY = "43515846-b11e9eae3cad2c2a65fb4bc33"
const val BASE_URL = "https://pixabay.com/api/"

interface ApiService {
    @GET("?key=${KEY}")
    suspend fun getPhoto(@Query("q") q: String, @Query("image_type") imageType: String = "photo") : PhotoNet
}