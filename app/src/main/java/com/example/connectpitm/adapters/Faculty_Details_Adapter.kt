package com.example.connectpitm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.connectpitm.R
import com.example.connectpitm.models.Faculty_Details_Model

class Faculty_Details_Adapter(val facultyDetailsList: ArrayList<Faculty_Details_Model>): RecyclerView.Adapter<Faculty_Details_Adapter.MyViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.faculty_cardview, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.facultyImg.setImageResource(facultyDetailsList[position].imgCard)
        holder.facultyName.setText(facultyDetailsList[position].fName)
        holder.facultydepartment.setText(facultyDetailsList[position].fDepartement)
        holder.facultyContact.setText(facultyDetailsList[position].fContact)
    }

    override fun getItemCount(): Int {
        return facultyDetailsList.size
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var facultyImg: ImageView
        var facultyName: TextView
        var facultydepartment: TextView
        var facultyContact: TextView

        init {
            facultyImg = itemView.findViewById(R.id.cardViewImg)
            facultyName = itemView.findViewById(R.id.cardViewFacultyN)
            facultydepartment = itemView.findViewById(R.id.cardViewDepartment)
            facultyContact = itemView.findViewById(R.id.cardViewContact)
        }

    }

}