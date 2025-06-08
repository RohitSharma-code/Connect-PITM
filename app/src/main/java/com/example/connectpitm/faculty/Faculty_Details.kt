package com.example.connectpitm.faculty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.connectpitm.R
import com.example.connectpitm.adapters.Faculty_Details_Adapter
import com.example.connectpitm.models.Faculty_Details_Model

class Faculty_Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty_details)

        //1. AdapterView: Recycler(Card View)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewFaculty)

        //Set Layout Manager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Data Source: List of game list object
        var newFacultyList: ArrayList<Faculty_Details_Model> = ArrayList()

        var f1 = Faculty_Details_Model(R.drawable.navigation_iconsvg, "Aman", "BCA", "Gandu")
        var f2 = Faculty_Details_Model(R.drawable.drawer_header_logo, "Nasir", "BCA", "Ladhchat")
        var f3 = Faculty_Details_Model(R.drawable.slide1, "Abhishek", "BCA", "Harami")
        var f4 = Faculty_Details_Model(R.drawable.moduleimg2, "Piyush", "BCA", "Nuni")
        var f5 = Faculty_Details_Model(R.drawable.facultysvg, "Taufique", "BCA", "land")
        var f6 = Faculty_Details_Model(R.drawable.navigation_iconsvg, "Rajesh", "BCA", "paglachoda")

        newFacultyList.add(f1)
        newFacultyList.add(f2)
        newFacultyList.add(f3)
        newFacultyList.add(f4)
        newFacultyList.add(f5)
        newFacultyList.add(f6)

        //3. Adapter
        val adapter = Faculty_Details_Adapter(newFacultyList)
        recyclerView.adapter = adapter

    }
}