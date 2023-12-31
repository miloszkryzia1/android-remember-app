package com.example.trellocloneapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import com.example.trellocloneapp.MainActivity
import com.example.trellocloneapp.R
import com.example.trellocloneapp.adapters.LabelPickerAdapter

class LabelPickerFragment : Fragment() {

    private var boardId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            boardId = it.getInt("boardId")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_label_picker, container, false)
        val spinner = view.findViewById<Spinner>(R.id.labelPickerSpinner)
        val board = MainActivity.boardList.find { it.id == boardId }
        spinner.adapter = LabelPickerAdapter(board!!.labels)
        return view
    }
}