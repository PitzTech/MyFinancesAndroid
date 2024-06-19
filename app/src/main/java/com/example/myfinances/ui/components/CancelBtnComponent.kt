package com.example.myfinances.ui.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.myfinances.R
import kotlinx.coroutines.*

class CancelBtnComponent : Fragment() {

    private var job: Job? = null
    private lateinit var cancelButton: CardView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.cancel_btn_component, container, false)

        cancelButton = view.findViewById(R.id.cancel_button)
        cancelButton.setOnClickListener {
            cancelOperation()
        }

        startOperation()

        return view
    }

    private fun startOperation() {
        job = CoroutineScope(Dispatchers.IO).launch {
            // Simulando uma operação de longa duração
            for (i in 1..10) {
                delay(1000)
                if (isActive) {
                    println("Operation running... $i")
                } else {
                    println("Operation was cancelled")
                    return@launch
                }
            }
            println("Operation completed")
        }
    }

    private fun cancelOperation() {
        job?.cancel()
        Toast.makeText(requireContext(), "Operation cancelled", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        job?.cancel()
    }
}
