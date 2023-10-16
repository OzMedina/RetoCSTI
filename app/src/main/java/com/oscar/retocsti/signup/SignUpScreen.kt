package com.oscar.retocsti.signup

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
import com.oscar.retocsti.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen() {
    val viewModel = hiltViewModel<SignUpViewModel>()
    val isRegister = viewModel.register.collectAsState().value

    val context = LocalContext.current
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    if (isRegister != null && isRegister) {
        Toast.makeText(context, "Se registro correctamente", Toast.LENGTH_SHORT).show()
    } else if (isRegister != null && !isRegister) {
        Toast.makeText(context, "Ocurrio un error en el registro", Toast.LENGTH_SHORT).show()
    }

    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Icon(
            modifier = Modifier.clickable { viewModel.goToBackStack() },
            painter = painterResource(id = com.google.android.material.R.drawable.ic_arrow_back_black_24),
            contentDescription = "Arrow Back",
        )
        Column(modifier = Modifier.fillMaxWidth().align(Alignment.Center)) {
            Text(text = "Sign Up", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Looks like you don't have an account.\nLet's create a new account for xxx@xxx.com")
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = { newText ->
                    email = newText
                },
                label = { Text(text = "Email") },
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = { newText ->
                    password = newText
                },
                label = { Text(text = "Password") },
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "By selecting Agree and continue below.\nI agree to Terms of Service and Privacy Policy")
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { viewModel.register(email = email.text, password = password.text) },
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(text = "Agree and continue", modifier = Modifier.padding(8.dp))
            }
        }
    }
}
