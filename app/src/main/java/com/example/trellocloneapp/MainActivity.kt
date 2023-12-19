package com.example.trellocloneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: This is only for testing the layout, change in the future
        val boardFragment = BoardFragment()
        val args: Bundle = Bundle()
        args.putString("name", "Test Bard")
        boardFragment.arguments = args
        supportFragmentManager.beginTransaction().add(R.id.homePageFrame, boardFragment).commit()
    }
}