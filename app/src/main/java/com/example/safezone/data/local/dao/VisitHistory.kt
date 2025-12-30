package com.example.safezone.data.local.dao

import androidx.room.*
import com.example.safezone.data.local.entity.VisitHistoryEntity

@Dao
interface VisitHistoryDao {

    @Insert
    suspend fun insertVisit(visit: VisitHistoryEntity)

    @Query("SELECT * FROM visit_history")
    suspend fun getAllVisits(): List<VisitHistoryEntity>
}
