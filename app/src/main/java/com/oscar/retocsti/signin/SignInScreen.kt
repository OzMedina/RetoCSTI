package com.oscar.retocsti.signin

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.material.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(email: String?) {
    val viewModel = hiltViewModel<SignInViewModel>()
    val isLogin = viewModel.login.collectAsState().value

    val context = LocalContext.current
    var password by remember { mutableStateOf(TextFieldValue("")) }

    if (isLogin != null && !isLogin) {
        Toast.makeText(context, "Usuario y/o contraseña incorrectos.", Toast.LENGTH_SHORT).show()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Icon(
            modifier = Modifier.clickable { viewModel.goToBackStack() },
            painter = painterResource(id = R.drawable.ic_arrow_back_black_24),
            contentDescription = "Arrow Back",
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
        ) {
            Text(text = "Log in", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Correo: $email")
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = { newText ->
                    password = newText
                },
                label = { Text(text = "Password") },
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { viewModel.login(email = email.orEmpty(), password = password.text) },
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(text = "Continue", modifier = Modifier.padding(8.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Forgot your password")
        }
    }
}
