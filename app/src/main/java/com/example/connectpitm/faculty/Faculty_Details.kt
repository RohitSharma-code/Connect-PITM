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

        var f1 = Faculty_Details_Model(R.drawable.faculty_photo, "Dr. Arnab Chattopadhyay", "Principle", "NA")
        var f2 = Faculty_Details_Model(R.drawable.faculty_photo, "Prof. Shourya Sikhar Kar", "Director", "NA")
        var f3 = Faculty_Details_Model(R.drawable.faculty_photo, "Prof. Dipanjan Kumar Dey", "HOD BCA", "NA")
        var f4 = Faculty_Details_Model(R.drawable.faculty_photo, "Prof. Anuradha Chatterjee", "HOD BBA", "NA")
        var f5 = Faculty_Details_Model(R.drawable.faculty_photo, "Dr. Sanjukta Mallick Chattopadhyay", "BCA", "NA")
        var f6 = Faculty_Details_Model(R.drawable.faculty_photo, "Dr. Paramita Sarkar", "BCA", "NA")
        var f7 = Faculty_Details_Model(R.drawable.faculty_photo, "Prof. Nandini Mitra", "BCA", "NA")
        var f8 = Faculty_Details_Model(R.drawable.faculty_photo, "Prof. Rajib Chandra Kumar", "BCA", "NA")
        var f9 = Faculty_Details_Model(R.drawable.faculty_photo, "Prof. Rammani Sarkar", "BCA", "NA")
        var f10 = Faculty_Details_Model(R.drawable.faculty_photo, "Prof. Monsori Kar", "BCA", "NA")
        var f11 = Faculty_Details_Model(R.drawable.faculty_photo, "Prof. Koushani Chakraborty", "BCA", "NA")
        var f12 = Faculty_Details_Model(R.drawable.faculty_photo, "Prof. Anindita Dey", "BCA", "NA")
        var f13 = Faculty_Details_Model(R.drawable.faculty_photo, "Prof. Sayan Chakraborty", "BCA", "NA")
        var f14 = Faculty_Details_Model(R.drawable.faculty_photo, "Prof. Ruma Mukhopadhyay", "BCA", "NA")
        var f15 = Faculty_Details_Model(R.drawable.faculty_photo, "Prof. Sudipa Chakraborty", "BCA", "NA")

        newFacultyList.add(f1)
        newFacultyList.add(f2)
        newFacultyList.add(f3)
        newFacultyList.add(f4)
        newFacultyList.add(f5)
        newFacultyList.add(f6)
        newFacultyList.add(f7)
        newFacultyList.add(f8)
        newFacultyList.add(f9)
        newFacultyList.add(f10)
        newFacultyList.add(f11)
        newFacultyList.add(f12)
        newFacultyList.add(f13)
        newFacultyList.add(f14)
        newFacultyList.add(f15)

        //3. Adapter
        val adapter = Faculty_Details_Adapter(newFacultyList)
        recyclerView.adapter = adapter
    }
}