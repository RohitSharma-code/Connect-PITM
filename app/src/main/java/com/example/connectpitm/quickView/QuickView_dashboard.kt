package com.example.connectpitm.quickView

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codebyashish.autoimageslider.AutoImageSlider
import com.codebyashish.autoimageslider.Enums.ImageScaleType
import com.codebyashish.autoimageslider.Models.ImageSlidesModel
import com.example.connectpitm.R
import com.example.connectpitm.adapters.quickView_dashboard_Adapter
import com.google.android.material.appbar.MaterialToolbar
import quickView_dashboardModel

class quickView_dashboard : AppCompatActivity() {
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quick_view_dashboard)

        // Initialize DrawerLayout
        drawerLayout = findViewById(R.id.quickView_dashboard)

        // Initialize Toolbar
        val toolbar: MaterialToolbar = findViewById(R.id.quickView_topAppBar)
        setSupportActionBar(toolbar)

        // Ensure the navigation icon remains the same
        toolbar.setNavigationIcon(R.drawable.navigation_iconsvg)

        // Setup ActionBarDrawerToggle
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Handle edge-to-edge insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.quickView_dashboard)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up RecyclerView with LinearLayoutManager
        val quickViewRecyclerView: RecyclerView = findViewById(R.id.quickView_recyclerView)
        quickViewRecyclerView.layoutManager = LinearLayoutManager(this)

        // Create a list of modules for RecyclerView
        val moduleList = listOf(
            quickView_dashboardModel("About Us", aboutUs::class.java),
            quickView_dashboardModel("Department", department::class.java),
            quickView_dashboardModel("Website", website::class.java),
            quickView_dashboardModel("Enquiry Form", enquiryForm::class.java)
        )


        // Initialize the adapter with the module list
        val adapter = quickView_dashboard_Adapter(moduleList)
        quickViewRecyclerView.adapter = adapter

        // Set up OnClickListener for RecyclerView items
        adapter.setOnItemClickListener(object : quickView_dashboard_Adapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val selectedItem = moduleList[position]
                val intent = Intent(this@quickView_dashboard, selectedItem.activityClass)
                startActivity(intent)
            }
        })


        // Create an imageArrayList to hold ImageSlideModel objects
        val autoImageList: ArrayList<ImageSlidesModel> = ArrayList()

        // Find and initialize ImageSlider
        val autoImageSlider = findViewById<AutoImageSlider>(R.id.quickView_autoImageSlider)

        // Add images to the ImageSlider
        autoImageList.add(ImageSlidesModel(R.drawable.slide1, ""))
        autoImageList.add(ImageSlidesModel(R.drawable.slide2, ""))
        autoImageList.add(ImageSlidesModel(R.drawable.slide3, ""))

        // Set the images in the AutoImageSlider with ImageScaleType
        autoImageSlider.setImageList(autoImageList, ImageScaleType.FIT)

        // Set default animation for the ImageSlider
        autoImageSlider.setDefaultAnimation()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle navigation item selection
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
