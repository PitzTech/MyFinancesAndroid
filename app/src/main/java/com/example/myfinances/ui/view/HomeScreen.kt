package com.example.myfinances.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myfinances.ui.navigation.NavRoutes
import com.example.myfinances.ui.viewmodel.TransactionViewModel
import com.example.myfinances.ui.viewmodel.UserViewModel
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun HomeScreen(
    transactionViewModel: TransactionViewModel,
    userViewModel: UserViewModel,
    navController: NavHostController
) {
    val currentDate = LocalDate.now()
    val dayOfWeek =
        currentDate.dayOfWeek.getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault())
    val formattedDate = currentDate.format(DateTimeFormatter.ofPattern("MM/dd"))

    val currentUser by userViewModel.user.observeAsState()
    val transactions by transactionViewModel.transactions.observeAsState()

    LaunchedEffect(currentUser) {
        currentUser?.let {
            transactionViewModel.loadTransactions(it.id.toInt())
        }
    }

    val userTransactions =
        transactions?.filter { it.userId == currentUser?.id?.toInt() } ?: emptyList()

    val totalIncome = userTransactions.filter { it.type == "income" }.sumOf { it.value }
    val totalOutcome = userTransactions.filter { it.type == "outcome" }.sumOf { it.value }

    fun handleAddTransaction() {
        navController.navigate(NavRoutes.ADD_TRANSACTION)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "$dayOfWeek, $formattedDate",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 18.sp,
                color = Color.White
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Your balance is \$${"%.2f".format(totalIncome - totalOutcome)}",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            IncomeOutcomeCard(
                title = "Total income",
                amount = "+\$${"%.2f".format(totalIncome)}",
                since = "since 03/16",
                backgroundColor = Color(0xFF00E676)
            )
            Spacer(modifier = Modifier.width(8.dp))
            IncomeOutcomeCard(
                title = "Total outcome",
                amount = "-\$${"%.2f".format(totalOutcome)}",
                since = "since 03/16",
                backgroundColor = Color(0xFFFF5252)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Transactions",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 18.sp,
                color = Color.White
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            var searchText by remember { mutableStateOf("") }
            BasicTextField(
                value = searchText,
                onValueChange = { searchText = it },
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .padding(16.dp)
                    .weight(1f),
                textStyle = TextStyle(fontSize = 16.sp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = { handleAddTransaction() }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color(0xFF009688), RoundedCornerShape(12.dp))
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        if (userTransactions.isNotEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                userTransactions.forEach { transaction ->
                    TransactionItem(
                        description = transaction.title,
                        amount = if (transaction.type == "income") "+\$${"%.2f".format(transaction.value)}" else "-\$${
                            "%.2f".format(
                                transaction.value
                            )
                        }",
                        date = DateTimeFormatter.ofPattern("MM/dd").format(
                            transaction.date.toInstant().atZone(ZoneId.systemDefault())
                                .toLocalDate()
                        ),
                        category = transaction.category,
                        from = "from ${transaction.category}",
                        backgroundColor = if (transaction.type == "income") Color(0xFF00E676) else Color(
                            0xFFFF5252
                        )
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                }
            }
        } else {
            Text(
                text = "No transactions available",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 18.sp,
                    color = Color.White
                )
            )
        }
    }
}

@Composable
fun IncomeOutcomeCard(title: String, amount: String, since: String, backgroundColor: Color) {
    Column(
        modifier = Modifier
            .background(backgroundColor, RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 16.sp,
                color = Color.White
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = amount,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )
    }
}

@Composable
fun TransactionItem(
    description: String,
    amount: String,
    date: String,
    category: String,
    from: String,
    backgroundColor: Color
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor, RoundedCornerShape(12.dp))
            .padding(16.dp)
            .padding(bottom = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 16.sp,
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = category,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 12.sp,
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = from,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 12.sp,
                        color = Color.White
                    )
                )
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = amount,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 16.sp,
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = date,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 12.sp,
                        color = Color.White
                    )
                )
            }
        }
    }
}
