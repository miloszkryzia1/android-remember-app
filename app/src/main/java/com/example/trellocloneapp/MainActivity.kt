package com.example.trellocloneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {

    private lateinit var navMenuToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set fragment for most recent board
        // TODO: This is only for testing the layout, change in the future
        val boardFragment = BoardFragment()
        val args: Bundle = Bundle()
        args.putString("name", "Test Bard")
        boardFragment.arguments = args
        supportFragmentManager.beginTransaction().add(R.id.homePageFrame, boardFragment).commit()

        //Navigation Drawer
        val drawer = findViewById<DrawerLayout>(R.id.mainDrawer)
        navMenuToggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(navMenuToggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Button func
        val btn = findViewById<Button>(R.id.homePageButton)
        btn.setOnClickListener { openNewBoardScreen() }
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

    private fun openNewBoardScreen() {
        intent = Intent(this, NewBoardActivity::class.java)
        intent.putExtra("previous", "main")
        startActivity(intent)
    }
}