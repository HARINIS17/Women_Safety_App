package com.example.safezone.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.safezone.data.local.dao.*
import com.example.safezone.data.local.entity.*

@Database(
    entities = [
        AreaEntity::class,
        AreaRiskEntity::class,
        EmergencyEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun areaDao(): AreaDao
    abstract fun areaRiskDao(): AreaRiskDao
    abstract fun emergencyDao(): EmergencyDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "safezone_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
