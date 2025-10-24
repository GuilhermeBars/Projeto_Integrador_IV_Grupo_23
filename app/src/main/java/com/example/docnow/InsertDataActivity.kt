package com.example.docnow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.activity.compose.BackHandler
import com.example.docnow.ui.theme.DocNowTheme

class InsertDataActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DocNowTheme {

                insertDataPage()

            }
        }
    }
}

data class Biomarcador(
    val id: String,
    val name: String,
    val metric: String,
    val profile: String,
    var value: String
);


val biomarcadores = listOf(
    Biomarcador( "teste1", "Teste 1", "mg/dl", "Lipídico", ""  ),
    Biomarcador( "teste2", "Teste 2", "mg/dl", "Metabólico", "")
)

@Composable
fun insertDataPage(){
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
                .fillMaxSize()
                .padding(top = 60.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        ){
            for (biomarcador in biomarcadores){
                var dataEntry by remember { mutableStateOf(biomarcador.value) };
                var isChecked by remember { mutableStateOf(false) }
            Row(){
                Checkbox( checked = isChecked,
                    onCheckedChange = { isChecked = it })
                UnderlineTextField(value = dataEntry, label = biomarcador.name, isPassword = false, onValueChange = { dataEntry = it }, enable = isChecked )
            }
            }
        }
    }
}
