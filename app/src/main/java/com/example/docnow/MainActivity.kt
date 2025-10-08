package com.example.docnow

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
import com.example.docnow.ui.theme.DocNowTheme
import com.example.docnow.ui.theme.Preto
import com.example.docnow.ui.theme.Vermelho
import com.example.docnow.ui.theme.Vermelho2
import com.example.docnow.ui.theme.VermelhoB


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DocNowTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var nome by remember { mutableStateOf("Felipe") }

    /*ButtonDefault(
        color1 = Azul,
        color2 = Branco,
        label = "teste"
    )*/
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        UnderlineTextField(
            value = nome,
            onValueChange = { nome = it },
            label = "Nome",
            isPassword = true
        )
        /*ProgressCircle(percentage = 32f, mainColor = Vermelho)
        ProgressCircle(percentage = 65f, mainColor = Amarelo )
        ProgressCircle(percentage = 85f, mainColor = Azul)*/
        ProgressCard(title = "Colesterol",
            measure = "50mg/dl",
            message = "Seu colesterol esta abaixo do normal",
            mainColor = Vermelho,
            textColor = Preto,
            borderColor = VermelhoB,
            secondaryColor = Vermelho2,
            percentage = 85f)
    }



}


