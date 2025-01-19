package com.example.connectpitm

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codebyashish.autoimageslider.AutoImageSlider
import com.codebyashish.autoimageslider.Enums.ImageScaleType
import com.codebyashish.autoimageslider.Models.ImageSlidesModel
import com.google.android.material.appbar.MaterialToolbar

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

        val quickViewRecyclerView: RecyclerView = findViewById(R.id.quickView_recyclerView)
        quickViewRecyclerView.layoutManager = LinearLayoutManager(this)

        val moduleList = listOf(
            quickView_dashboardModel("About Us"),
            quickView_dashboardModel("Department"),
            quickView_dashboardModel("Website"),
            quickView_dashboardModel("Enquiry Form"),

        )

        val adapter = quickView_dashboard_Adapter(moduleList)
        quickViewRecyclerView.adapter = adapter


//        ******************************************************************************************

        // create an imageArrayList which extend ImageSlideModel class
        val autoImageList : ArrayList<ImageSlidesModel> = ArrayList()

        // find and initialize ImageSlider
        val autoImageSlider = findViewById<AutoImageSlider>(R.id.quickView_autoImageSlider)

        // add some imagees or titles (text) inside the imagesArrayList
        autoImageList.add(ImageSlidesModel( R.drawable.slide1,""))
        autoImageList.add(ImageSlidesModel(R.drawable.slide2,""))
        autoImageList.add(ImageSlidesModel( R.drawable.slide3,""))

        // set the added images inside the AutoImageSlider
        autoImageSlider.setImageList(autoImageList, ImageScaleType.FIT)

        // set any default animation or custom animation (setSlideAnimation(ImageAnimationTypes.ZOOM_IN))
        autoImageSlider.setDefaultAnimation()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}