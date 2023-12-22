package com.example.trellocloneapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.trellocloneapp.R

class BoardFragment : Fragment() {
    private var name: String? = null
    private var color: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = arguments?.getString("name")
            color = arguments?.getInt("color")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_board, container, false)
        view.findViewById<TextView>(R.id.boardName).text = name
        val colorImg = view.findViewById<ImageView>(R.id.colorImg)
        when (color) {
            R.color.brdColor1 -> colorImg.setImageResource(R.drawable.brd_color_shape_1)
            R.color.brdColor2 -> colorImg.setImageResource(R.drawable.brd_color_shape_2)
            R.color.brdColor3 -> colorImg.setImageResource(R.drawable.brd_color_shape_3)
            R.color.brdColor4 -> colorImg.setImageResource(R.drawable.brd_color_shape_4)
            R.color.brdColor5 -> colorImg.setImageResource(R.drawable.brd_color_shape_5)
        }
        return view
    }
}