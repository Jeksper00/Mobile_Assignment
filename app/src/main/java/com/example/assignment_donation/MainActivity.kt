package com.example.assignment_donation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
//import androidx.navigation.Navigation.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
//import androidx.navigation.ui.setupWithNavController
import com.example.assignment_donation.fragments.FavouritesFragment
import com.example.assignment_donation.fragments.HomeFragment
import com.example.assignment_donation.fragments.ProfileFragment
import com.example.assignment_donation.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.internal.NavigationMenuItemView
import com.google.android.material.navigation.NavigationBarMenu
import com.google.android.material.navigation.NavigationBarMenuView

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