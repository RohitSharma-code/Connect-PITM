package com.example.connectpitm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.connectpitm.R
import quickView_dashboardModel

class quickView_dashboard_Adapter(private val moduleList: List<quickView_dashboardModel>)
    : RecyclerView.Adapter<quickView_dashboard_Adapter.ViewHolder>() {

    // Interface for handling click events on RecyclerView items
    private lateinit var mlistener: onItemClickListener

    // Define the click listener interface
    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    // Function to set the click listener from the activity/fragment
    fun setOnItemClickListener(listener: onItemClickListener) {
        mlistener = listener
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.quick_view_dashboard_module, parent, false)
        return ViewHolder(view, mlistener)  // Pass the click listener to the ViewHolder
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.moduleNameView.text = moduleList[position].title  // Set the module title
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return moduleList.size
    }

    // Provide a reference to the type of views that you are using (custom ViewHolder)
    inner class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val moduleNameView: TextView = itemView.findViewById(R.id.quickView_moduleName)  // Reference to the TextView

        init {
            // Set the click listener for the itemView
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)  // Call the listener's onItemClick method
            }
        }
    }
}
