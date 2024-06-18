package com.example.myfinances.ui.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.myfinances.databinding.SearchComponentBinding

class SearchComponent : Fragment() {

    private lateinit var binding: SearchComponentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = SearchComponentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bank = arrayOf("Nubank", "C6", "Inter", "Banco do Brasil", "Santander", "Bradesco", "Caixa", "Itaú", "BRB")

        val bankAdapter: ArrayAdapter<String> = ArrayAdapter(
            requireContext(), android.R.layout.simple_list_item_1, bank
        )

        binding.bankList.adapter = bankAdapter

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                if (bank.contains(query)) {
                    bankAdapter.filter.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                bankAdapter.filter.filter(newText)
                return false
            }
        })
    }
}
