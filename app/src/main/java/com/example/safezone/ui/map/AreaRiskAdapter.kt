package com.example.safezone.ui.map

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.safezone.R
import com.example.safezone.data.local.entity.AreaRiskEntity

class AreaRiskAdapter(
    private val list: List<AreaRiskEntity>
) : RecyclerView.Adapter<AreaRiskAdapter.VH>() {

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val area = view.findViewById<TextView>(R.id.txtAreaId)
        val risk = view.findViewById<TextView>(R.id.txtRisk)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_area_risk, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(h: VH, pos: Int) {
        val item = list[pos]
        h.area.text = item.areaId
        h.risk.text = item.riskLevel

        when (item.riskLevel) {
            "SAFE" -> h.itemView.setBackgroundColor(Color.parseColor("#C8E6C9"))
            "CAUTION" -> h.itemView.setBackgroundColor(Color.parseColor("#FFF9C4"))
            "DANGER" -> h.itemView.setBackgroundColor(Color.parseColor("#FFCDD2"))
        }
    }

    override fun getItemCount() = list.size
}
