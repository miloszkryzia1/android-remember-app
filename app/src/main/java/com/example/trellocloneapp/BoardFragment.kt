package com.example.trellocloneapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

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
        //TODO: Set the color of category
        return view
    }
}