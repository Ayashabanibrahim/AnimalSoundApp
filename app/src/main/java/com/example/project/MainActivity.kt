package com.example.project

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.project.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
var animalFav=Array(14){false}
var birdFav=Array(14){false}
lateinit var animalName:Array<String>
lateinit var animalImage:Array<Int>
lateinit var animalSound:Array<Int>
lateinit var birdName:Array<String>
lateinit var birdImage:Array<Int>
lateinit var birdSound:Array<Int>
 var mediaPlayer2: MediaPlayer? = null
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    lateinit var drawerLayout: androidx.drawerlayout.widget.DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        drawerLayout = binding.main
        setStatusBarColor(("#327606"))
        val toolbar = binding.tolBar
        setSupportActionBar(toolbar)
        val navigationView = binding.navView

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // إعداد الـ NavController للتنقل بين الـ Fragments

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(navigationView, navController)

        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_home -> {
                 this.supportActionBar?.title="Sound Animal"
                mediaPlayer2?.stop()
                mediaPlayer2?.release()
                mediaPlayer2=null
                navigateToDestination(R.id.homeFragment)
            }
            R.id.nav_animal -> {
                supportActionBar?.title=null
                mediaPlayer2?.stop()
                mediaPlayer2?.release()
                mediaPlayer2 = null
                navigateToDestination(R.id.animalFragment)
            }
            R.id.nav_birds -> {
                supportActionBar?.title=null
                mediaPlayer2?.stop()
                mediaPlayer2?.release()
                mediaPlayer2 = null
                navigateToDestination(R.id.birdFragment)
            }
            R.id.nav_fav -> {
                supportActionBar?.title=null
                mediaPlayer2?.stop()
                mediaPlayer2?.release()
                mediaPlayer2 = null
                navigateToDestination(R.id.favFragment)
            }
            R.id.nav_about -> {
                supportActionBar?.title=null
                mediaPlayer2?.stop()
                mediaPlayer2?.release()
                mediaPlayer2 = null
                navigateToDestination(R.id.aboutFragment)
            }
            R.id.nav_exit -> {
                supportActionBar?.title=null
                mediaPlayer2?.stop()
                mediaPlayer2?.release()
                mediaPlayer2 = null
                Toast.makeText(this, "Exit!", Toast.LENGTH_SHORT).show()
                finishAffinity()

            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


    private fun navigateToDestination(destinationId: Int) {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(destinationId)
    }
    private fun setStatusBarColor(color: String) {
            window.statusBarColor = Color.parseColor(color)
    }

}