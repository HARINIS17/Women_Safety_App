package com.example.safezone

import android.app.Application
import android.util.Log // <-- Import Log
import com.example.safezone.data.repository.AreaRepository
import com.example.safezone.data.repository.AreaRiskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class SafeZoneApp : Application() {

    // Create a SupervisorJob to prevent one failure from cancelling the whole scope
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        preloadDatabase()
    }

    private fun preloadDatabase() {
        applicationScope.launch {
            try {
                // Initialize instances
                val areaRepo = AreaRepository(this@SafeZoneApp)
                val riskRepo = AreaRiskRepository(this@SafeZoneApp)

                // Execute preloading
                areaRepo.preloadIfNeeded()
                riskRepo.preloadIfNeeded()
            } catch (e: Exception) {
                Log.e("SafeZoneApp", "Database preloading failed", e)
            }
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        // Cancel the scope when the application is terminated
        applicationScope.cancel()
    }
}
