package com.example.connectpitm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.connectpitm.R
import com.example.connectpitm.models.Faculty_Model
import com.example.connectpitm.models.dashboardModel

class Faculty_Adapter(val moduleList: List<Faculty_Model>,
                      val clickListener: (Faculty_Model) -> Unit): RecyclerView.Adapter<Faculty_Adapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var facNameView: TextView = itemView.findViewById(R.id.moduleName)
        var facImageView: ImageView = itemView.findViewById(R.id.moduleImage)

        fun bind(model: Faculty_Model){
            facNameView.text = model.itemName
            facImageView.setImageResource(model.itemImg)

            itemView.setOnClickListener {
                clickListener(model)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Faculty_Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dashboard_module, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moduleList.size
    }

    override fun onBindViewHolder(holder: Faculty_Adapter.ViewHolder, position: Int) {
        holder.bind(moduleList[position])
    }

}