package com.example.docnow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.BackHandler
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.docnow.ui.theme.Azul
import com.example.docnow.ui.theme.Branco
import com.example.docnow.ui.theme.DocNowTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DocNowTheme {
                loginScreen()

            }
        }
    }
}

@Composable
fun loginScreen(){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    
    // Handler para o botão de voltar do sistema
    BackHandler {
        (context as ComponentActivity).finish()
    }
    
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Botão de voltar no canto superior esquerdo
        BackButton(
            onClick = { 
                (context as ComponentActivity).finish()
            },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        )
        
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
        UnderlineTextField(
            label = "Email",
            value = email,
            isPassword = false,
            onValueChange = { email = it },
            enable = true
        )
        UnderlineTextField(
        label = "Senha",
        value = password,
        isPassword = false,
        onValueChange = { password = it },
        enable = true
    )
        ButtonDefault(
            color1 = Branco,
            color2 = Azul,
            label = "Login",
            onClick = {""}
        )
        }
    }
}
