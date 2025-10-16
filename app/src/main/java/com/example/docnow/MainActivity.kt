package com.example.docnow

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.docnow.ui.theme.Azul
import com.example.docnow.ui.theme.Branco
import com.example.docnow.ui.theme.DocNowTheme
import com.example.docnow.ui.theme.Preto
import com.example.docnow.ui.theme.Vermelho
import com.example.docnow.ui.theme.Vermelho2
import com.example.docnow.ui.theme.VermelhoB
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DocNowTheme {

                   homePage()


            }
        }
    }
}

@Composable
fun homePage(){
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize() ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ButtonDefault(
            color1 = Azul,
            color2 = Branco,
            label = "Cadastrar",
            onClick = {
                val intent = Intent(context, SignUpActivity::class.java)
                context.startActivity(intent)
            }
        )
        ButtonDefault(
            color1 = Branco,
            color2 = Azul,
            label = "Login",
            onClick = {
                val intent = Intent(context, LoginActivity::class.java)
                context.startActivity(intent)
            }
        )
        ButtonDefault(
            color1 = Branco,
            color2 = Azul,
            label = "Results",
            onClick = {
                val intent = Intent(context, ResutsActivity::class.java)
                context.startActivity(intent)
            }
        )
    }
}
