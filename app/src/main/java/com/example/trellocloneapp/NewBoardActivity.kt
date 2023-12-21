package com.example.trellocloneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout

class NewBoardActivity : AppCompatActivity() {

    private lateinit var navMenuToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_board)

        //Nav menu toggle setup
        val drawer = findViewById<DrawerLayout>(R.id.newBoardDrawer)
        navMenuToggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(navMenuToggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Cancel button func
        val cancelBtn = findViewById<Button>(R.id.cancelButton)
        cancelBtn.setOnClickListener{ cancelButtonPressed() }
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

    private fun cancelButtonPressed() {
        when (intent.extras?.getString("previous")) {
            "main" -> {
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}