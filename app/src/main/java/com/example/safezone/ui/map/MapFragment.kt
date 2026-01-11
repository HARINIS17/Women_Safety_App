package com.example.safezone.ui.map

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.safezone.R
import com.example.safezone.data.local.AppDatabase
import com.example.safezone.domain.logic.RiskEngine
import com.example.safezone.ui.settings.SettingsActivity
import kotlinx.coroutines.launch
import java.util.Calendar

class MapFragment : Fragment(R.layout.fragment_map) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Settings button
        val settingsBtn = view.findViewById<Button>(R.id.btnSettings)
        settingsBtn.setOnClickListener {
            startActivity(
                Intent(requireContext(), SettingsActivity::class.java)
            )
        }

        // RecyclerView setup
        val recycler = view.findViewById<RecyclerView>(R.id.areaRecyclerView)
        recycler.layoutManager = LinearLayoutManager(requireContext())

        // Load DB + apply RiskEngine
        lifecycleScope.launch {

            val data = AppDatabase
                .getDatabase(requireContext())
                .areaRiskDao()
                .getAllRisks()

            val hour = Calendar.getInstance()
                .get(Calendar.HOUR_OF_DAY)

            val enhancedList = data.map {
                val (score, level) = RiskEngine.calculateRisk(
                    authorityScore = it.riskScore,
                    userFeedbackScore = 50, // placeholder
                    hourOfDay = hour
                )
                it.copy(riskScore = score, riskLevel = level)
            }

            recycler.adapter = AreaRiskAdapter(enhancedList)
        }
    }
}
