package com.example.dameuncoctel.splash

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.dameuncoctel.R
import com.example.dameuncoctel.login.ActivityLogin

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the layout for the content view.


        val splash = installSplashScreen()



        splash.setKeepOnScreenCondition {  true }

        val intent = Intent(this, ActivityLogin::class.java)
        //Dormimos 1s el hilo, lo correcto seria implementar una logica que comprobase que esta cargada la app,
        Thread.sleep(1000)
        startActivity(intent)
        this.finish()

        // Set up an OnPreDrawListener to the root view.



    }
}