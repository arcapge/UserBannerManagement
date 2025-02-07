package com.cg.arpisinh.bannerandusermanagement.ui.activity.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cg.arpisinh.bannerandusermanagement.ui.activity.login.viewmodel.LoginViewModel

class LoginActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginScreen(
                mobileNumber = loginViewModel.mobileNumber.value,
                selectedRole = loginViewModel.selectedRole.value,
                isValidNumber = loginViewModel.isValidNumber.value,
                onMobileNumberChange = { number ->
                    loginViewModel.updateMobileNumber(number)
                },
                onRoleChange = { role ->
                    loginViewModel.updateRole(role)
                },
                onLoginClick = { loginViewModel.sendOtp() }
            )
        }
    }
}

@Composable
fun LoginScreen(
    mobileNumber: String,
    selectedRole: String,
    isValidNumber: Boolean,
    onMobileNumberChange: (String) -> Unit,
    onRoleChange: (String) -> Unit,
    onLoginClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth().background(Color.White).padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Login", fontSize = 28.sp, color = Color.Black
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            label = {
                Text("Enter Mobile Number")
            },
            modifier = Modifier.fillMaxWidth(),
            value = mobileNumber,
            onValueChange = onMobileNumberChange,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            isError = !isValidNumber
        )
        if (!isValidNumber) {
            Text(text = "Enter a valid 10 digit number", color = Color.Red, fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            RadioButton(
                selected = selectedRole == "User",
                onClick = { onRoleChange("User") }
            )
            Text(text = "User")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = onLoginClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Send OTP")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogin() {
    LoginScreen(
        mobileNumber = "",
        selectedRole = "User",
        isValidNumber = true,
        onMobileNumberChange = { },
        onRoleChange = { },
        onLoginClick = { }
    )
}