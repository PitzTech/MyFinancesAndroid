package com.example.myfinances.ui.components

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myfinances.R
import java.text.SimpleDateFormat
import java.util.Locale

class DateComponent : Fragment() {
    private lateinit var datePicker: TextView
    private lateinit var btnDatePicker: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.date_component, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        datePicker = view.findViewById(R.id.datePicker)
        btnDatePicker = view.findViewById(R.id.btnDatePicker)

        val myCalendar = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(myCalendar)
        }

        btnDatePicker.setOnClickListener {
            context?.let {
                DatePickerDialog(it, datePickerDialog, myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show()
            }
        }
    }

    private fun updateLabel(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        datePicker.text = sdf.format(myCalendar.time)
    }
}
