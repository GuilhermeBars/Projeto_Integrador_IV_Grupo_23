package com.example.docnow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.docnow.ui.theme.Azul
import com.example.docnow.ui.theme.Branco
import com.example.docnow.ui.theme.DocNowTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DocNowTheme {
                signUpScreen()

            }
        }
    }
}

@Composable
fun signUpScreen(){
    var name by remember { mutableStateOf("") }
    var birth by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize() ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        UnderlineTextField(
            label = "Nome",
            value = name,
            isPassword = false,
            onValueChange = { name = it }
        )
        UnderlineTextField(
            label = "Email",
            value = email,
            isPassword = false,
            onValueChange = { email = it }
        )
        UnderlineTextField(
            label = "Senha",
            value = password,
            isPassword = true,
            onValueChange = { password = it }
        )
        ButtonDefault(
            color1 = Azul,
            color2 = Branco,
            label = "Cadastrar",
            onClick = {""}
        )
    }
}
