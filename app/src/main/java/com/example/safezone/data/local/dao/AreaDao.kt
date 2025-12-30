package com.example.safezone.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.safezone.data.local.entity.AreaEntity

@Dao
interface AreaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAreas(list: List<AreaEntity>)

    @Query("SELECT * FROM areas")
    suspend fun getAllAreas(): List<AreaEntity>
}
