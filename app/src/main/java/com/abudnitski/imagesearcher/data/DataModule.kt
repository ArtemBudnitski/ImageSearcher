package com.abudnitski.imagesearcher.data

import android.content.Context
import com.abudnitski.imagesearcher.data.api.ApiService
import com.abudnitski.imagesearcher.data.api.BASE_URL
import com.abudnitski.imagesearcher.data.db.AppDatabase
import com.abudnitski.imagesearcher.data.db.PhotoDao
import com.abudnitski.imagesearcher.domain.PhotoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun providePhotoRepo(
        photoDao: PhotoDao,
        photoMapper: PhotoMapper,
        apiService: ApiService
    ): PhotoRepository {
        return PhotoRepository(
            photoDao = photoDao,
            photoMapper = photoMapper,
            apiService = apiService
        )
    }

    @Provides
    fun providePhotoDao(db: AppDatabase): PhotoDao {
        return db.photoDao()
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}