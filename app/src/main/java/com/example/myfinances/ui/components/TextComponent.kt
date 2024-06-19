package com.example.myfinances.ui.components

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myfinances.databinding.TextComponentBinding

class TextComponent : Fragment() {

    private var _binding: TextComponentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View? {
        _binding = TextComponentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //  TextWatcher monitora mudanças
        binding.titleTextComp.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                validateFields()
            }
        })

        binding.valueTextComp.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                validateFields()
            }
        })
    }

    private fun validateFields(): Boolean {
        val titleText = binding.titleTextComp.text.toString()
        val valueText = binding.valueTextComp.text.toString()

        if (titleText.length <= 3) {
            binding.titleTextComp.error = "O título deve ter mais de 3 caracteres"
            return false
        }

        val value = valueText.toDoubleOrNull()
        if (value == null || value == 0.0) {
            binding.valueTextComp.error = "O valor deve ser diferente de zero"
            return false
        }

        // Limpar erros se tudo estiver correto
        binding.titleTextComp.error = null
        binding.valueTextComp.error = null

        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null  // limpa pra evitar memory leaks
    }
}