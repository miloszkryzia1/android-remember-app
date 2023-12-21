package com.example.trellocloneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {

    private lateinit var navMenuToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: This is only for testing the layout, change in the future
        val boardFragment = BoardFragment()
        val args: Bundle = Bundle()
        args.putString("name", "Test Bard")
        boardFragment.arguments = args
        supportFragmentManager.beginTransaction().add(R.id.homePageFrame, boardFragment).commit()

        val drawer = findViewById<DrawerLayout>(R.id.mainDrawer)

        navMenuToggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)

        drawer.addDrawerListener(navMenuToggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        navMenuToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (navMenuToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}