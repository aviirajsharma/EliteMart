package com.cscorner.elitemart.ui.feature.account.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cscorner.elitemart.navigation.HomeScreen
import com.cscorner.elitemart.navigation.RegisterScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = koinViewModel()) {

    val loginState = viewModel.loginState.collectAsState()
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        when (val state = loginState.value) {

            is LoginState.Success -> {
                LaunchedEffect (loginState.value){
                    navController.navigate(HomeScreen){
                        popUpTo(HomeScreen){
                            inclusive = true
                        }
                    }
                }
            }
            is LoginState.Loading ->{
                CircularProgressIndicator()
                Text(text = "Loading..")
            }
            is LoginState.Error -> {
                Text(state.message)
            }
            else -> {
                LoginContent(onSignInClicked = {email, password ->
                    viewModel.login(email, password)
                },
                    onRegisterClicked = {
                        navController.navigate(RegisterScreen)
                    }
                )
            }
        }
    }

}


@Composable
fun LoginContent(onSignInClicked:(String, String) -> Unit, onRegisterClicked:() -> Unit) {

    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login", style = MaterialTheme.typography.titleLarge)
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            label = { Text("Email:") }
        )
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = {
                onSignInClicked(email.value, password.value)
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = email.value.isNotBlank() && password.value.isNotBlank()
        ) {
            Text("Login")
        }
        Text(text = "Don't have an account? Register", modifier = Modifier.padding(8.dp).clickable { onRegisterClicked() })
    }
}

@Composable
@Preview(showBackground = true)
fun LoginPreview() {
    LoginContent(onSignInClicked = {email, password ->

    }, onRegisterClicked = {})
}