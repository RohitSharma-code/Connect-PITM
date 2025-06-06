package com.example.connectpitm.activities

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codebyashish.autoimageslider.AutoImageSlider
import com.codebyashish.autoimageslider.Enums.ImageScaleType
import com.codebyashish.autoimageslider.Models.ImageSlidesModel
import com.example.connectpitm.R
import com.example.connectpitm.adapters.dashboard_Adapter
import com.example.connectpitm.models.dashboardModel
import com.example.connectpitm.quickView.quickView_dashboard
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class student_dashboard : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_dashboard)

        // Initialize DrawerLayout
        drawerLayout = findViewById(R.id.student_dashboard)

        // Initialize Toolbar
        val toolbar: MaterialToolbar = findViewById(R.id.topAppBar)
        setSupportActionBar(toolbar)

        // Ensure the navigation icon remains the same
        toolbar.setNavigationIcon(R.drawable.navigation_iconsvg)

        // Setup ActionBarDrawerToggle
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Setup RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // Corrected Line
             // Line Changed

        // Populate DataSource
        val moduleList = listOf(
            dashboardModel("Website", R.drawable.moduleimg1),
            dashboardModel("Portal", R.drawable.moduleimg2),
            dashboardModel("Notes", R.drawable.moduleimg3),
            dashboardModel("Notice", R.drawable.moduleimg4),
            dashboardModel("Faculty", R.drawable.moduleimg5),
            dashboardModel("Maps", R.drawable.moduleimg6)
        )

        // Set Adapter
        val adapter = dashboard_Adapter(moduleList){model ->
            when(model.moduleName){
                "Website" -> {
                    val url = "https://www.pitmkol.com"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                }

                "Portal" -> {
                    val url = "https://www.makautexam.net/"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                }

                "Notes" -> {
                    Toast.makeText(this, "Notes Clicked", Toast.LENGTH_SHORT).show()
                }

                "Notice" -> {
                    Toast.makeText(this, "Notice Clicked", Toast.LENGTH_SHORT).show()
                }

                "Faculty" -> {
                    Toast.makeText(this, "Faculty Clicked", Toast.LENGTH_SHORT).show()
                }

                "Maps" -> {
                    val geoUri = "https://www.google.com/maps/place/Prajnanananda+Institute+Of+Technology+%26+Management/@22.5417973,88.3674832,17z/data=!3m1!4b1!4m6!3m5!1s0x3a0276e0cbc50b91:0x56bda8626e2aaa17!8m2!3d22.5417973!4d88.3674832!16s%2Fg%2F11g8bt7851?entry=ttu&g_ep=EgoyMDI1MDEyMi4wIKXMDSoASAFQAw%3D%3D"
                    val map = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
                    startActivity(map)
                }
            }
        }
        recyclerView.adapter = adapter // Line Added


//        *****************************************************************

        // create an imageArrayList which extend ImageSlideModel class
        val autoImageList : ArrayList<ImageSlidesModel> = ArrayList()

        // find and initialize ImageSlider
        val autoImageSlider = findViewById<AutoImageSlider>(R.id.autoImageSlider)

        // add some imagees or titles (text) inside the imagesArrayList
        autoImageList.add(ImageSlidesModel(R.drawable.slide1,""))
        autoImageList.add(ImageSlidesModel(R.drawable.slide2,""))
        autoImageList.add(ImageSlidesModel(R.drawable.slide3,""))

        // set the added images inside the AutoImageSlider
        autoImageSlider.setImageList(autoImageList, ImageScaleType.FIT)

        // set any default animation or custom animation (setSlideAnimation(ImageAnimationTypes.ZOOM_IN))
        autoImageSlider.setDefaultAnimation()

        //Navigation view id initialize
        navigationView = findViewById(R.id.navView)
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
