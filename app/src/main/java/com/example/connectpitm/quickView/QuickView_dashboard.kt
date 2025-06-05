package com.example.connectpitm.quickView

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codebyashish.autoimageslider.AutoImageSlider
import com.codebyashish.autoimageslider.Enums.ImageScaleType
import com.codebyashish.autoimageslider.Models.ImageSlidesModel
import com.example.connectpitm.R
import com.example.connectpitm.adapters.quickView_dashboard_Adapter
import com.example.connectpitm.databinding.DrawerHeaderBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import quickView_dashboardModel


class quickView_dashboard : AppCompatActivity() {
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quick_view_dashboard)

        // Initialize DrawerLayout
        drawerLayout = findViewById(R.id.quickView_dashboard)

        //Navigation view id initialize
        navigationView = findViewById(R.id.navView)

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

        // Set up RecyclerView with LinearLayoutManager
        val quickViewRecyclerView: RecyclerView = findViewById(R.id.quickView_recyclerView)
        quickViewRecyclerView.layoutManager = LinearLayoutManager(this)

        // Create a list of modules for RecyclerView
        val moduleList = listOf(
            quickView_dashboardModel("About Us", aboutUs::class.java),
            quickView_dashboardModel("Department", department::class.java),
            quickView_dashboardModel("Website", null, "https://pitmkol.com"), // Specify the URL
            quickView_dashboardModel("Enquiry Form", enquiryForm::class.java)
        )

        // Initialize the adapter with the module list
        val adapter = quickView_dashboard_Adapter(moduleList)
        quickViewRecyclerView.adapter = adapter

        // Set up OnClickListener for RecyclerView items
        adapter.setOnItemClickListener(object : quickView_dashboard_Adapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val selectedItem = moduleList[position]

                if (selectedItem.url != null) {
                    // Open the URL in a browser
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse(selectedItem.url)
                    }
                    startActivity(intent)
                } else if (selectedItem.activityClass != null) {
                    // Navigate to the specified activity
                    val intent = Intent(this@quickView_dashboard, selectedItem.activityClass)
                    startActivity(intent)
                }
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


        // MAP intent
        val locationButton: TextView = findViewById(R.id.Map)
        // Set a click listener for the button
        locationButton.setOnClickListener {
            // The desired location as a geo URI
            val geoUri =
                "https://www.google.com/maps/place/Prajnanananda+Institute+Of+Technology+%26+Management/@22.5417973,88.3674832,17z/data=!3m1!4b1!4m6!3m5!1s0x3a0276e0cbc50b91:0x56bda8626e2aaa17!8m2!3d22.5417973!4d88.3674832!16s%2Fg%2F11g8bt7851?entry=ttu&g_ep=EgoyMDI1MDEyMi4wIKXMDSoASAFQAw%3D%3D"

            // Create an implicit intent
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))

            // Ensure there’s an app to handle the intent
            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            } else {
                Toast.makeText(this, "No app to handle maps!", Toast.LENGTH_SHORT).show()
            }
        }

        //Function for navigation drawer items
        navigationView.setNavigationItemSelectedListener(){
            when(it.itemId){
                R.id.contact -> {openDialerWithNumber("8697580473")}
                R.id.emailMenu -> {openGmail()}
                R.id.rateUs -> {
                    Toast.makeText(this, "Rate Us Clicked", Toast.LENGTH_LONG).show()
                }
                R.id.share -> {shareAppLink(this)}
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle navigation item selection
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    //Open Dialer
    private fun openDialerWithNumber(phoneNumber: String){
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel: $phoneNumber")
        startActivity(intent)
    }

    //Sharing the app(Implicit Intent)
    private fun shareAppLink(context: Context){
        val packageName = context.packageName
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
        shareIntent.putExtra(Intent.EXTRA_SUBJECT,"App Recommendation")
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey Checkout this awesome app! ${gPlayAppLink(packageName)}")
        startActivity(shareIntent)
    }
    private fun gPlayAppLink(packageName: String): String{
        return "https://play.google.com/store/apps/details?id=$packageName"
    }

    //Open Gmail
    private fun openGmail(){
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:connectpitm@gmail.com")
        }
        startActivity(intent)
    }
}
