package com.example.myfinances.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myfinances.data.database.AppDatabase
import com.example.myfinances.data.repository.TransactionRepository
import com.example.myfinances.databinding.ActivityMenuBinding
import com.example.myfinances.ui.viewmodel.MenuViewModel
import com.example.myfinances.ui.viewmodel.MenuViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

class MenuActivity : AppCompatActivity() {

    private lateinit var menuViewModel: MenuViewModel
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transactionDao = AppDatabase.getDatabase(this).transactionDao()
        val transactionRepository = TransactionRepository(transactionDao)
        val menuViewModelFactory = MenuViewModelFactory(transactionRepository)
        menuViewModel = ViewModelProvider(this, menuViewModelFactory).get(MenuViewModel::class.java)

        // Atualizar data automaticamente
        updateDate()

        // Atualizar balanço automaticamente
        menuViewModel.balance.observe(this, Observer { balance ->
            binding.textViewBalance.text = balance.toString()
        })
        menuViewModel.loadBalance()

        // Mostrar resumo das despesas e receitas
        menuViewModel.expensesSummary.observe(this, Observer { expensesSummary ->
            binding.textViewExpensesSummary.text = expensesSummary
        })
        menuViewModel.loadExpensesSummary()

        menuViewModel.incomeSummary.observe(this, Observer { incomeSummary ->
            binding.textViewIncomeSummary.text = incomeSummary
        })
        menuViewModel.loadIncomeSummary()

        // Listar todas as transações
        menuViewModel.transactions.observe(this, Observer { transactions ->
            // Aqui você pode configurar um adapter para o ListView para mostrar as transações
            // Por exemplo:
            // val adapter = TransactionsAdapter(this, transactions)
            // binding.listViewTransactions.adapter = adapter
        })
        menuViewModel.loadTransactions()

        // Configurar listener para o botão Cartões
        binding.buttonCards.setOnClickListener {
            navigateToCardsScreen()
        }

        // Configurar listener para o botão Despesas
        binding.buttonExpenses.setOnClickListener {
            navigateToExpensesScreen()
        }

        // Configurar listener para o botão Receitas
        binding.buttonIncome.setOnClickListener {
            navigateToIncomeScreen()
        }

        // Configurar listener para o botão Configurações
        binding.buttonSettings.setOnClickListener {
            navigateToSettingsScreen()
        }
    }

    private fun updateDate() {
        val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        binding.textViewDate.text = currentDate
    }

    private fun navigateToCardsScreen() {
        Toast.makeText(this, "Navigating to Cards Screen", Toast.LENGTH_SHORT).show()
        // startActivity(Intent(this, CardsActivity::class.java))
    }

    private fun navigateToExpensesScreen() {
        Toast.makeText(this, "Navigating to Expenses Screen", Toast.LENGTH_SHORT).show()
        // startActivity(Intent(this, ExpensesActivity::class.java))
    }

    private fun navigateToIncomeScreen() {
        Toast.makeText(this, "Navigating to Income Screen", Toast.LENGTH_SHORT).show()
        // startActivity(Intent(this, IncomeActivity::class.java))
    }

    private fun navigateToSettingsScreen() {
        Toast.makeText(this, "Navigating to Settings Screen", Toast.LENGTH_SHORT).show()
        // startActivity(Intent(this, SettingsActivity::class.java))
    }
}
