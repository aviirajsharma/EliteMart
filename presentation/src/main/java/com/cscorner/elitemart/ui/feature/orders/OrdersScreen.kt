package com.cscorner.elitemart.ui.feature.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cscorner.domain.model.OrdersData
import org.koin.androidx.compose.koinViewModel

@Composable
fun OrdersScreen(viewModel: OrdersViewModel = koinViewModel()) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                "Orders",
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.titleMedium
            )
        }
        val uiState = viewModel.orderEvent.collectAsState()
        //Tab Row
        val tabs = listOf("All", "Pending", "Delivered", "Cancelled")
        val selectedTab = remember {
            mutableStateOf(0)
        }
        TabRow(selectedTabIndex = selectedTab.value) {
            tabs.forEachIndexed { index, title ->
                Box(
                    modifier = Modifier.clickable {
                        selectedTab.value = index
                    }
                ) {
                    Text(
                        title,
                        modifier = Modifier.padding(8.dp).align(Alignment.Center),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        when (uiState.value) {
            is OrdersEvent.Loading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                    Text("Loading")
                }
            }

            is OrdersEvent.Success -> {
                val orders = (uiState.value as OrdersEvent.Success).data
                when (selectedTab.value) {
                    0 -> {
                        OrdersList(orders = orders)
                    }

                    1 -> {
                        OrdersList(orders = viewModel.filterOrders(orders, "Pending"))
                    }

                    2 -> {
                        OrdersList(orders = viewModel.filterOrders(orders, "Delivered"))
                    }

                    3 -> {
                        OrdersList(orders = viewModel.filterOrders(orders, "Cancelled"))
                    }
                }
            }

            is OrdersEvent.Error -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = (uiState.value as OrdersEvent.Error).error)
                }
            }
        }
    }
}

@Composable
fun OrdersList(orders: List<OrdersData>) {
    if (orders.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("No Orders")
        }
    } else {
        LazyColumn {
            items(orders, key = { order -> order.id }) {
                OrderItem(order = it)
            }
        }
    }
}

@Composable
fun OrderItem(order: OrdersData) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                Color.LightGray.copy(alpha = 0.4f)
            )
            .padding(8.dp)
    ) {
        Text("Order Id: ${order.id}")
        Text("Order Date: ${order.orderDate}")
        Text("Total Amount: ${order.totalAmount}")
        Text("Status: ${order.status}")
    }
}
