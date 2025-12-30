package com.example.safezone.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "areas")
data class AreaEntity(
    @PrimaryKey
    val areaId: String,
    val districtName: String,
    val areaName: String
)
