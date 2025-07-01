package com.cscorner.elitemart.ui.feature.summary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cscorner.domain.model.CartItemModel
import com.cscorner.domain.model.CartSummary
import org.koin.androidx.compose.koinViewModel

@Composable
fun CartSummaryScreen(
    navController: NavController,
    viewModel: CartSummaryViewModel = koinViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(
                "Cart Summary",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }
        val uiState = viewModel.uiState.collectAsState()
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            when (val event = uiState.value) {
                is CartSummaryEvent.Loading -> {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.align(Alignment.Center)
                    ) {
                        //show loading
                        CircularProgressIndicator()
                        Text("Loading", style = MaterialTheme.typography.titleMedium)
                    }
                }

                is CartSummaryEvent.Error -> {
                    //show error
                    Text(
                        text = event.message,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                is CartSummaryEvent.Success -> {
                    //show success
                    CartSummaryScreenContent(event.summary)
                }
            }
        }
        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text("Checkout", style = MaterialTheme.typography.titleMedium)
        }
    }
}


@Composable
fun CartSummaryScreenContent(cartSummary: CartSummary) {
    LazyColumn {
        item {
            Text(
                text = "Products",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        items(cartSummary.data.items) { cartItem ->
            ProductRow(cartItem)
        }
        item {
            Column {
                Text(
                    text = "Amount",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                AmountRow("Subtotal", cartSummary.data.subtotal)
                AmountRow("Tax", cartSummary.data.tax)
                AmountRow("Delivery Charges", cartSummary.data.shipping)
                AmountRow("Discount", cartSummary.data.discount)
                AmountRow("Total", cartSummary.data.total)
            }
        }
    }
}

@Composable
fun ProductRow(cartItemModel: CartItemModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = cartItemModel.productName,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "₹${cartItemModel.price} x ${cartItemModel.quantity} = ₹${cartItemModel.price * cartItemModel.quantity}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun AmountRow(title: String, amount: Double) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyMedium
        )
        Text(text = "₹${amount}", style = MaterialTheme.typography.bodyMedium)
    }
}