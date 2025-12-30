package com.example.safezone.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "visit_history")
data class VisitHistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val visitId: Int = 0,
    val areaId: String,
    val timestamp: Long,
    val riskLevelAtVisit: String
)
