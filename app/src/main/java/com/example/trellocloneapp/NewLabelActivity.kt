package com.example.trellocloneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trellocloneapp.adapters.LabelColorAdapter

class NewLabelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_label)

        //TODO: GET BOARD ETC

        //Recycler view
        val recView = findViewById<RecyclerView>(R.id.lblColorRecView)
        recView.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        val colorList = listOf(
            R.color.lblColor1,
            R.color.lblColor2,
            R.color.lblColor3,
            R.color.lblColor4,
            R.color.lblColor5,
            R.color.lblColor6
        )
        recView.adapter = LabelColorAdapter(colorList)
    }
}