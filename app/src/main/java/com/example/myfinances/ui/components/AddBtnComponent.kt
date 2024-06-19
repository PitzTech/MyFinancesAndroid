package com.example.myfinances.ui.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.myfinances.R

class AddBtnComponent : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.add_btn_component, container, false)

        val addButton: CardView = view.findViewById(R.id.add_button)
        addButton.setOnClickListener {
            addIncome()
        }

        return view
    }

    //add income ou add expense
    private fun addIncome() {
        // implementar codigo
        Toast.makeText(requireContext(), "Income added", Toast.LENGTH_SHORT).show()
    }
}
