package com.example.safezone.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "area_risk")
data class AreaRiskEntity(
    @PrimaryKey
    val areaId: String,
    val incidentCountApprox: Int,
    val riskScore: Int,
    val riskLevel: String,
    val lastUpdatedYear: Int
)
