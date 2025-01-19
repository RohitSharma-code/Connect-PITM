package com.example.connectpitm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class quickView_dashboard_Adapter(val moduleList: List<quickView_dashboardModel>)
    :RecyclerView.Adapter<quickView_dashboard_Adapter.ViewHolder>(){


//        ViewHolder
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var moduleNameView : TextView = itemView.findViewById(R.id.quickView_moduleName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : quickView_dashboard_Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.quick_view_dashboard_module,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: quickView_dashboard_Adapter.ViewHolder, position: Int) {
        holder.moduleNameView.setText(moduleList[position].moduleName)
    }

    override fun getItemCount(): Int {
        return moduleList.size
    }

}