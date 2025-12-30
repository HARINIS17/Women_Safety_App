package com.example.safezone.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feedback")
data class FeedbackEntity(
    @PrimaryKey(autoGenerate = true)
    val feedbackId: Int = 0,
    val areaId: String,
    val rating: String, // SAFE / UNSAFE
    val comment: String?,
    val timestamp: Long
)
