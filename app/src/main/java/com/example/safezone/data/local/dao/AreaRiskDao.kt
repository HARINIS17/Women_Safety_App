package com.example.safezone.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.safezone.data.local.entity.AreaRiskEntity

@Dao
interface AreaRiskDao{

    @Query("SELECT * FROM area_risk")
    suspend fun getAllRisks(): List<AreaRiskEntity>

    @Query("SELECT COUNT(*) FROM area_risk")
    suspend fun getCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<AreaRiskEntity>)
}
