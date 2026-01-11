package com.example.safezone.data.repository

import android.content.Context
import android.util.Log
import com.example.safezone.data.local.AppDatabase
import com.example.safezone.data.local.entity.AreaRiskEntity
import org.json.JSONArray
import androidx.room.Insert
import androidx.room.OnConflictStrategy

class AreaRiskRepository(private val context: Context) {

    private val dao = AppDatabase.getDatabase(context).areaRiskDao()

    suspend fun preloadIfNeeded() {
        if (dao.getCount() > 0) return

        Log.d("DB_CHECK", "Loading area_risk.json")

        val json = context.assets.open("area_risk.json")
            .bufferedReader().use { it.readText() }

        val arr = JSONArray(json)
        val list = mutableListOf<AreaRiskEntity>()

        for (i in 0 until arr.length()) {
            val o = arr.getJSONObject(i)
            list.add(
                AreaRiskEntity(
                    areaId = o.getString("areaId"),
                    incidentCountApprox = o.getInt("incidentCountApprox"),
                    riskScore = o.getInt("riskScore"),
                    riskLevel = o.getString("riskLevel"),
                    lastUpdatedYear = o.getInt("lastUpdatedYear")
                )
            )
        }

        dao.insertAll(list)
        Log.d("DB_CHECK", "Risk inserted")
    }
}
