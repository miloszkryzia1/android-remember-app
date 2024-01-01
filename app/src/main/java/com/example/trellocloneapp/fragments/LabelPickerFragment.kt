package com.example.trellocloneapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Spinner
import com.example.trellocloneapp.MainActivity
import com.example.trellocloneapp.R
import com.example.trellocloneapp.adapters.LabelPickerAdapter
import com.example.trellocloneapp.models.LabelModel

class LabelPickerFragment : Fragment() {

    var currentLabel: LabelModel? = null
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
        currentLabel = board.labels[0]
        spinner.onItemSelectedListener = object: OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                currentLabel = board.labels[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        return view
    }
}