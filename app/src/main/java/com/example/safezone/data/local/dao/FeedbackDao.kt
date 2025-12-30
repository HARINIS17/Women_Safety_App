package com.example.safezone.data.local.dao

import androidx.room.*
import com.example.safezone.data.local.entity.FeedbackEntity

@Dao
interface FeedbackDao {

    @Insert
    suspend fun insertFeedback(feedback: FeedbackEntity)

    @Query("SELECT * FROM feedback WHERE areaId = :areaId")
    suspend fun getFeedbackForArea(areaId: String): List<FeedbackEntity>
}
