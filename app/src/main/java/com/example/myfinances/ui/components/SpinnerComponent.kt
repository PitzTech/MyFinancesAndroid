package com.example.myfinances.ui.components

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.myfinances.R

class SpinnerComponent : Fragment() {

    private lateinit var context: Context
    private lateinit var onCategorySelectedListener: OnCategorySelectedListener

    //permite que o fragmento comunique a categoria selecionada de volta para a atividade ou fragmento que o hospeda
    interface OnCategorySelectedListener {
        fun onCategorySelected(category: String)
    }

    //garante que a atividade hopedeira implemente 'OnCategorySelectedListener'
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
        try {
            onCategorySelectedListener = context as OnCategorySelectedListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnCategorySelectedListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.spinner_component, container, false)

        val spinner = rootView.findViewById<Spinner>(R.id.spinnerComp)

        // exemplos de categorias
        val categories = listOf(
            "Alimentação",
            "Transporte",
            "Moradia",
            "Educação",
            "Saúde",
            "Lazer",
            "Outros"
        )

        // adapter para fornecer os dados que o Spinner precisa exibir aos usuários
        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, categories)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) // layout do dropdown

        spinner.adapter = adapter

        // Definir o listener para a seleção do Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedCategory = parent.getItemAtPosition(position) as String
                onCategorySelectedListener.onCategorySelected(selectedCategory)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Ação quando nada estiver selecionado
            }
        }

        return rootView
    }
}
