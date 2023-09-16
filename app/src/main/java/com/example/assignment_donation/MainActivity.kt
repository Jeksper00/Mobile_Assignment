package com.example.assignment_donation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
//import androidx.navigation.Navigation.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
//import androidx.navigation.ui.setupWithNavController
import com.example.assignment_donation.DonorFragments.FavouritesFragment
import com.example.assignment_donation.DonorFragments.HomeFragment
import com.example.assignment_donation.DonorFragments.ProfileFragment
import com.example.assignment_donation.DonorFragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val favouritesFragment = FavouritesFragment()
        val settingsFragment = SettingsFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.baseline_home_24 -> makeCurrentFragment(homeFragment)
                R.id.baseline_favorite_24 -> makeCurrentFragment(favouritesFragment)
                R.id.baseline_setting_24 -> makeCurrentFragment(settingsFragment)
                R.id.baseline_profile_24 -> makeCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.fl_wrapper, fragment)
        commit()
    }

}