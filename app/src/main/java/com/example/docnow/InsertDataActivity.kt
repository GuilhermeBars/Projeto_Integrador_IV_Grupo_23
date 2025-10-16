package com.example.docnow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    Column(){
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
