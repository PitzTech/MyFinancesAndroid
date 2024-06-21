package com.example.myfinances.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myfinances.data.model.Transaction
import com.example.myfinances.ui.components.BackButton
import com.example.myfinances.ui.components.CustomButton
import com.example.myfinances.ui.components.CustomDropdownMenu
import com.example.myfinances.ui.components.CustomTextField
import com.example.myfinances.ui.theme.primaryButton
import com.example.myfinances.ui.theme.primaryText
import com.example.myfinances.ui.theme.secondaryButton
import com.example.myfinances.ui.viewmodel.TransactionViewModel
import com.example.myfinances.ui.viewmodel.UserViewModel
import java.util.Date

@Composable
fun AddTransactionScreen(
    navController: NavHostController,
    transactionViewModel: TransactionViewModel,
    userViewModel: UserViewModel
) {
    var title by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var transactionType by remember { mutableStateOf("income") }
    val transactionTypes = listOf("income", "outcome")

    val currentUser by userViewModel.user.observeAsState()

    fun handleAddTransaction() {
        currentUser?.let {
            val transaction = Transaction(
                title = title,
                value = value.toDouble(),
                date = Date(),
                category = category,
                type = transactionType,
                userId = it.id.toInt()
            )
            transactionViewModel.addTransaction(transaction)
        }
        navController.popBackStack()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            BackButton(
                navController = navController,
                backgroundColor = MaterialTheme.colorScheme.secondaryButton,
                iconColor = MaterialTheme.colorScheme.background
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Add Transaction",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 32.sp,
                color = MaterialTheme.colorScheme.primaryText,
            )
        )

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            CustomTextField(
                value = title,
                onValueChange = { title = it },
                placeholder = "Title"
            )

            Spacer(modifier = Modifier.height(20.dp))

            CustomTextField(
                value = value,
                onValueChange = { value = it },
                placeholder = "Value",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(20.dp))

            CustomTextField(
                value = category,
                onValueChange = { category = it },
                placeholder = "Category"
            )

            Spacer(modifier = Modifier.height(20.dp))

            CustomDropdownMenu(
                options = transactionTypes,
                selectedOption = transactionType,
                onOptionSelected = { selectedType -> transactionType = selectedType },
                placeholder = "Type"
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            CustomButton(
                text = "Cancel",
                backgroundColor = MaterialTheme.colorScheme.secondaryButton,
                textColor = MaterialTheme.colorScheme.background,
                onClick = { navController.popBackStack() }
            )

            Spacer(modifier = Modifier.height(20.dp))

            CustomButton(
                text = "Add",
                backgroundColor = MaterialTheme.colorScheme.primaryButton,
                textColor = MaterialTheme.colorScheme.primaryText,
                onClick = { handleAddTransaction() }
            )

        }
    }
}
