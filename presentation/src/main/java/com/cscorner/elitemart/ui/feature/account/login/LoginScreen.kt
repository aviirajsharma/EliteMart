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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cscorner.elitemart.R
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
                Text(text = stringResource(id=R.string.loading))
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
        Text(stringResource(R.string.login), style = MaterialTheme.typography.titleLarge)
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .testTag("emailField"),
            label = { Text(stringResource(R.string.email)) }
        )
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .testTag("passwordField"),
            label = { Text(stringResource(R.string.password)) },
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = {
                onSignInClicked(email.value, password.value)
            },
            modifier = Modifier.fillMaxWidth().testTag("loginButton"),
            enabled = email.value.isNotBlank() && password.value.isNotBlank()
        ) {
            Text(stringResource(R.string.login))
        }
        Text(text = stringResource(R.string.don_t_have_an_account_register), modifier = Modifier
            .padding(8.dp)
            .clickable { onRegisterClicked() })
    }
}

@Composable
@Preview(showBackground = true)
fun LoginPreview() {
    LoginContent(onSignInClicked = {email, password ->

    }, onRegisterClicked = {})
}