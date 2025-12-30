package com.example.safezone.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.safezone.data.local.entity.EmergencyEntity

@Dao
interface EmergencyDao {

    @Insert
    suspend fun insertEmergency(emergency: EmergencyEntity)

    @Query("SELECT * FROM emergency")
    suspend fun getAllEmergencies(): List<EmergencyEntity>
}
