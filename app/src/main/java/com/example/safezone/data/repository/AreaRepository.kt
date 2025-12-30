package com.example.safezone.data.repository

import android.content.Context
import android.util.Log
import com.example.safezone.data.local.AppDatabase
import com.example.safezone.data.local.entity.AreaEntity
import org.json.JSONArray

class AreaRepository(private val context: Context) {

    private val dao = AppDatabase.getDatabase(context).areaDao()

    suspend fun preloadIfNeeded() {
        if (dao.getAllAreas().isNotEmpty()) return

        Log.d("DB_CHECK", "Loading areas.json")

        val json = context.assets.open("areas.json")
            .bufferedReader().use { it.readText() }

        val arr = JSONArray(json)
        val list = mutableListOf<AreaEntity>()

        for (i in 0 until arr.length()) {
            val o = arr.getJSONObject(i)
            list.add(
                AreaEntity(
                    areaId = o.getString("areaId"),
                    districtName = o.getString("district"),
                    areaName = o.getString("areaName")
                )
            )
        }

        dao.insertAreas(list)
        Log.d("DB_CHECK", "Areas inserted")
    }
}
