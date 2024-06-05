package com.abudnitski.imagesearcher.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PhotoDao {
    @Query("SELECT * FROM photoentity WHERE `query` = :query")
    suspend fun get(query: String) : List<PhotoEntity>

    @Query("SELECT * FROM photoentity WHERE id = :id")
    suspend fun find(id: String) : PhotoEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg photos: PhotoEntity)
}
