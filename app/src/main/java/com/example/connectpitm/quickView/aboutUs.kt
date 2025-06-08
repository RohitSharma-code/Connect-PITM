package com.example.connectpitm.quickView

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.connectpitm.R

class aboutUs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

//        define WebView
        val webView: WebView = findViewById(R.id.webView1)
        webView.getSettings().setJavaScriptEnabled(true);

        val htmlContent = """
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sample HTML Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        /* Container to add some spacing around the content */
        .container {
            width: 90%;
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: darkblue;
            margin-top: 20px;
        }

        h2 {
            color: darkgreen;
            margin-top: 40px;
            font-size: 24px;
        }

        h3 {
            color: darkred;
        }
        
        h4 {
            color: darkgreen;

        }

        p {
            text-align: justify;
            margin-bottom: 20px;
            font-size: 16px;
            color: #333;
        }

        img {
            width: 100%;
            height: auto;
            display: block;
            margin-bottom: 20px;
        }

        /* Animations */
        .fadeInUp {
            animation: fadeInUp 1s ease-out forwards;
        }

        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
</head>
<body>

    <div class="container">
        <!-- Image section -->
        <img src="file:///android_asset/about_us_img1.jpg" alt="Local Image" class="fadeInUp">

        <!-- Main heading -->
        <h2 class="wow fadeInUp">Access to Excellence</h2>

        <!-- Paragraphs with proper spacing and alignment -->
        <p class="wow fadeInUp">
            <b>Welcome to Prajnanananda Institute of Technology &amp; Management (PITM)</b>, an esteemed
            institution affiliated with <b>Maulana Abul Kalam Azad University of Technology (MAKAUT)</b>, West
            Bengal (formerly known as West Bengal University of Technology). PITM is approved by the <b>All India
            Council for Technical Education (AICTE)</b> and is committed to providing quality education in the
            fields of Bachelor of Computer Applications (Hons.) and Bachelor of Business Administration (Hons.). PITM is
            one of the best institutions to study the <b>BBA(H)</b> or the <b>BCA(H)</b> courses in Kolkata.
        </p>

        <p class="wow fadeInUp">
            In addition to rigorous academic programs, PITM offers various opportunities for students to engage in
            <b>practical learning experience, internship, industry interaction, and research project</b>.
            These experiences are designed to equip students with the knowledge, skills, and practical exposure
            necessary to succeed in their chosen fields.
        </p>

        <p class="wow fadeInUp">
            Additionally, <strong>PITM is committed to creating a safe and supportive campus environment</strong> for
            all students. As part of our commitment to student welfare, we have implemented <em><strong>anti-ragging</strong></em>
            measures to ensure that all students feel secure and valued throughout their academic journey.
        </p>

        <p class="wow fadeInUp">
            <strong>Whether you aspire to pursue a career</strong> in computer applications (BCA) or business
            administration (BBA), PITM provides the resources, support, and guidance you need to achieve your goals.
            Join us at PITM and embark on a transformative educational journey that will prepare you for a successful
            and fulfilling future.
        </p>
    </div>
    

<!-- Image Blocks Founder -->
<div class="row g-4">
    <div class="col-lg-3 col-md-6 fadeInUp" style="animation-delay: 0.1s; animation-name: fadeInUp; visibility: visible;">
        <div class="team-item" style="background-color: #f4f1de; border-radius: 24px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); text-align: center; padding: 16px;">
        
<!-- Image Blocks Founder -->
<div class="row g-4">
    <div class="col-lg-3 col-md-6 fadeInUp" style="animation-delay: 0.1s; animation-name: fadeInUp; visibility: visible;">
        <div class="team-item" style="background-color: #f8f9fa; border-radius: 8px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); text-align: center; padding: 16px;">
            <!-- Text content -->
            <div style="padding: 4px;">
                <h4 style="margin: 0 0 2px; font-size: 18px; color: #333;">Founder</h4>
            </div>

            <!-- Image container with circular shape -->
            <div class="position-relative d-flex align-items-center justify-content-center" style="margin: 16px auto; width: 150px; height: 150px;">
                <img class="img-fluid position-absolute rounded-circle" 
                     src="file:///android_asset/founder.jpg" 
                     alt="Late Shri Jyotsna Ranjan Kar" 
                     style="object-fit: cover; object-position: top; width: 100%; height: 100%; border: 3px solid #ccc;">
            </div>

            <!-- Text content -->
            <div style="padding: 16px;">
                <h5 style="margin: 0 0 2px; font-size: 18px; color: #333;">Late Shri Jyotsna Ranjan Kar</h5>
            </div>
        </div>
    </div>
</div>
<div style="border-bottom: 1px solid #ccc; margin: 20px 0;"></div>


<!-- Image Blocks Co-founder -->
<div class="row g-4">
    <div class="col-lg-3 col-md-6 fadeInUp" style="animation-delay: 0.1s; animation-name: fadeInUp; visibility: visible;">
        <div class="team-item" style="background-color: #f8f9fa; border-radius: 8px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); text-align: center;">
            <!-- Text content -->
            <div style="padding: 4px;">
                <h4 style="margin: 0 0 2px; font-size: 18px; color: #333;">Co-founder</h4>
            </div>

            <!-- Image container with circular shape -->
            <div class="position-relative d-flex align-items-center justify-content-center" style="margin: 16px auto; width: 150px; height: 150px;">
                <img class="img-fluid position-absolute rounded-circle" 
                     src="file:///android_asset/cofounder.jpg" 
                     alt="Debjani Kar" 
                     style="object-fit: cover; object-position: top; width: 100%; height: 100%; border: 3px solid #ccc;">
            </div>

            <!-- Text content -->
            <div style="padding: 4px;">
                <h5 style="margin: 0 0 2px; font-size: 18px; color: #333;">Debjani Kar</h5>
            </div>
        </div>
    </div>
</div>
<div style="border-bottom: 1px solid #ccc; margin: 20px 0;"></div>


<!-- Image Blocks Director -->
<div class="row g-4">
    <div class="col-lg-3 col-md-6 fadeInUp" style="animation-delay: 0.1s; animation-name: fadeInUp; visibility: visible;">
        <div class="team-item" style="background-color: #f8f9fa; border-radius: 8px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); text-align: center;">
            <!-- Text content -->
            <div style="padding: 4px;">
                <h4 style="margin: 0 0 2px; font-size: 18px; color: #333;">Director</h4>
            </div>

            <!-- Image container with circular shape -->
            <div class="position-relative d-flex align-items-center justify-content-center" style="margin: 16px auto; width: 150px; height: 150px;">
                <img class="img-fluid position-absolute rounded-circle" 
                     src="file:///android_asset/SSK.jpg" 
                     alt="Shourya Sikhar Kar" 
                     style="object-fit: cover; object-position: top; width: 100%; height: 100%; border: 3px solid #ccc;">
            </div>

            <!-- Text content -->
            <div style="padding: 4px;">
                <h5 style="margin: 0 0 2px; font-size: 18px; color: #333;">Shourya Sikhar Kar</h5>
                <small style="font-size: 14px; color: #666;">Director (B.E(CSE), MSc-IT)</small>
            </div>
        </div>
    </div>
</div>
<div style="border-bottom: 1px solid #ccc; margin: 20px 0;"></div>


<!-- Image Blocks Principal -->
<div class="row g-4">
    <div class="col-lg-3 col-md-6 fadeInUp" style="animation-delay: 0.1s; animation-name: fadeInUp; visibility: visible;">
        <div class="team-item" style="background-color: #f8f9fa; border-radius: 8px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); text-align: center;">
            <!-- Text content -->
            <div style="padding: 4px;">
                <h4 style="margin: 0 0 2px; font-size: 18px; color: #333;">Principal</h4>
            </div>

            <!-- Image container with circular shape -->
            <div class="position-relative d-flex align-items-center justify-content-center" style="margin: 16px auto; width: 150px; height: 150px;">
                <img class="img-fluid position-absolute rounded-circle" 
                     src="file:///android_asset/principal.jpg" 
                     alt="Dr Arnab Chattopadhyay" 
                     style="object-fit: cover; object-position: top; width: 100%; height: 100%; border: 3px solid #ccc;">
            </div>

            <!-- Text content -->
            <div style="padding: 4px;">
                <h5 style="margin: 0 0 2px; font-size: 18px; color: #333;">Dr Arnab Chattopadhyay</h5>
                <small style="font-size: 14px; color: #666;">Principal (BE, M.Tech, Ph.D)</small>
            </div>
        </div>
    </div>
</div>

</body>
</html>
        """

// Enable JavaScript if necessary
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

// Load the HTML content into the WebView
        webView.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null)



    }
}