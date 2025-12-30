package com.example.safezone.ui.map

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.safezone.R
import com.example.safezone.data.local.AppDatabase
import kotlinx.coroutines.launch

class MapFragment : Fragment(R.layout.fragment_map) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.areaRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        lifecycleScope.launch {
            val db = AppDatabase.getDatabase(requireContext())
            val areas = db.areaDao().getAllAreas()

            // TEMP LOG CHECK
            areas.forEach {
                android.util.Log.d("UI_CHECK", it.areaName)
            }
        }
    }
}
