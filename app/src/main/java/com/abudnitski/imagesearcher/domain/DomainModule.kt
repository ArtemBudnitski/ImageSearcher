package com.abudnitski.imagesearcher.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun providePhotoMapper(): PhotoMapper {
        return PhotoMapper()
    }
}