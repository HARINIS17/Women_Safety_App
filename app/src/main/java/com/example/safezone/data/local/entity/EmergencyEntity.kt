package com.example.safezone.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "emergency")
data class EmergencyEntity(
    @PrimaryKey(autoGenerate = true)
    val emergencyId: Int = 0,
    val areaId: String,
    val triggerType: String,
    val confidenceScore: Float,
    val isConfirmed: Boolean,
    val timestamp: Long
)
