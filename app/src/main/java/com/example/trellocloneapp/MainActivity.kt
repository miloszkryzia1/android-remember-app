package com.example.trellocloneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.trellocloneapp.fragments.BoardFragment
import com.example.trellocloneapp.fragments.NoBoardFragment
import com.example.trellocloneapp.models.BoardModel
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener

class MainActivity : AppCompatActivity() {

    companion object {
        val boardList = mutableListOf<BoardModel>()
        var mostRecentBoard: BoardModel? = null
    }

    private lateinit var navMenuToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set fragment for most recent board
        val trans = supportFragmentManager.beginTransaction()
        if (mostRecentBoard == null) {
            trans.add(R.id.homePageFrame, NoBoardFragment()).commit()
        }
        else {
            val args = Bundle()
            args.putString("name", mostRecentBoard!!.name)
            args.putInt("color", mostRecentBoard!!.color)
            val boardFrag = BoardFragment(mostRecentBoard!!)
            boardFrag.arguments = args
            trans.add(R.id.homePageFrame, boardFrag).commit()
        }

        //Navigation Drawer
        val drawer = findViewById<DrawerLayout>(R.id.mainDrawer)
        navMenuToggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(navMenuToggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navMenu = findViewById<NavigationView>(R.id.navView)
        navMenu.setNavigationItemSelectedListener {
            intent = Intent(this, BoardsActivity::class.java)
            startActivity(intent)
            true
        }

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