package com.example.safezone.ui.map

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.safezone.R

class AreaAdapter(
    private val list: List<AreaUiModel>
) : RecyclerView.Adapter<AreaAdapter.AreaViewHolder>() {

    class AreaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val areaName: TextView = view.findViewById(R.id.areaName)
        val riskLevel: TextView = view.findViewById(R.id.riskLevel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_area, parent, false)
        return AreaViewHolder(view)
    }

    override fun onBindViewHolder(holder: AreaViewHolder, position: Int) {
        val item = list[position]
        holder.areaName.text = item.areaName
        holder.riskLevel.text = item.riskLevel

        holder.riskLevel.setTextColor(
            when (item.riskLevel) {
                "SAFE" -> Color.GREEN
                "CAUTION" -> Color.parseColor("#FFA500")
                "DANGER" -> Color.RED
                else -> Color.BLACK
            }
        )
    }

    override fun getItemCount() = list.size
}
