package com.example.copycat.ui

import android.R.attr.onClick
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.copycat.R

@Composable
fun LoginLayout(modifier: Modifier = Modifier, navController: NavController, copyCatViewModel: CopyCatViewModel) {
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf( value = false)}

    val authState = copyCatViewModel.authState.observeAsState()

    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate("startHere")
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message,Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        EditLoginField(
            label = R.string.Email,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                autoCorrectEnabled = false,
                showKeyboardOnFocus = true,
                imeAction = ImeAction.Done
            ),
            value = emailInput,
            onValueChanged = { emailInput = it },
            modifier = Modifier
        )

        EditLoginField(
            label = R.string.Password,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                autoCorrectEnabled = false,
                showKeyboardOnFocus = true,
                imeAction = ImeAction.Done
            ),
            value = passwordInput,
            onValueChanged = { passwordInput = it },
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            modifier = Modifier,
            trailingIcon = {
                if (showPassword) {
                    IconButton(onClick = { showPassword = false}) {
                        Icon(
                            imageVector = Icons.Outlined.VisibilityOff,
                            contentDescription = "hide_password"
                        )
                    }
                } else {
                    IconButton(onClick = { showPassword = true}) {
                        Icon(
                            imageVector = Icons.Outlined.Visibility,
                            contentDescription = "hide_password"
                        )
                    }
                }
            }
        )

        Button( onClick = {copyCatViewModel.login(emailInput, passwordInput)},
            colors = ButtonDefaults.buttonColors(Color(166, 140, 217))) {
            Text("Login",
                color = Color(76,79,102))
        }

        TextButton( onClick = { navController.navigate("createAccount") }) {
            Text("Create Account",
                color = Color(166, 140, 217))
        }


    }
}



@Composable
fun EditLoginField(
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChanged: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    modifier: Modifier = Modifier,
    trailingIcon: @Composable (() -> Unit)? = null,

    ){
    OutlinedTextField(
        value = value,
        singleLine = true,
        modifier = modifier
            .fillMaxWidth(0.9f)
            .padding(vertical = 25.dp),
        onValueChange = onValueChanged,
        label = {Text(stringResource(label))},
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        shape = RoundedCornerShape(percent = 20),
        trailingIcon = trailingIcon
    )
}

