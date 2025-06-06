package com.example.connectpitm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.connectpitm.R
import com.example.connectpitm.models.dashboardModel
import com.example.connectpitm.quickView.quickView_dashboard

//      Adapter
//      moduleList stores the image and module names
class dashboard_Adapter(
    val moduleList: List<dashboardModel>,
    val clickListener: (dashboardModel) -> Unit
) : RecyclerView.Adapter<dashboard_Adapter.ViewHolder>() {


    //        ViewHolder
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var moduleNameView: TextView = itemView.findViewById(R.id.moduleName)
        var moduleImageView: ImageView = itemView.findViewById(R.id.moduleImage)

        fun bind(model: dashboardModel){
            moduleNameView.text = model.moduleName
            moduleImageView.setImageResource(model.moduleImage)

            itemView.setOnClickListener {
                clickListener(model)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dashboard_module, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moduleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(moduleList[position])
    }


}