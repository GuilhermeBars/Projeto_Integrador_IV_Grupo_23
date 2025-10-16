package com.example.docnow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.docnow.ui.theme.DocNowTheme

class ResutsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DocNowTheme {

                resultsPage()


            }
        }
    }
}

data class Exam(val title: String, val measure: String, val message: String, val percentage: Float);

val exams = listOf(
    Exam("Glicose", "85mg/dl", "Sua glicose está em nível ideal", 98f),
    Exam("Triglicerídeos", "220mg/dl", "Seus triglicerídeos estão muito altos", 35f),
    Exam("Creatinina", "2.1mg/dl", "Sua função renal está comprometida", 25f),
    Exam("Hemoglobina", "13.8g/dl", "Sua hemoglobina está normal", 90f),
    Exam("Ácido Úrico", "9.0mg/dl", "Seu ácido úrico está perigosamente alto", 10f),
    Exam("Vitamina D", "45ng/ml", "Bons níveis de vitamina D", 92f),
    Exam("TSH", "6.2uUI/ml", "Seu TSH está acima do ideal (possível hipotireoidismo)", 40f),
    Exam("HDL", "30mg/dl", "Seu HDL está baixo — aumente o colesterol bom", 50f),
    Exam("LDL", "70mg/dl", "Seu LDL está excelente", 100f),
    Exam("Ferritina", "12ng/ml", "Baixa reserva de ferro — possível anemia", 30f),

)


@Composable
fun resultsPage() {
    val scrollState = rememberScrollState()
    var sum = 0.0
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        exams.forEach{ exam ->
               sum += exam.percentage
           }
        var progressCirclePercentage = sum / exams.size

        ProgressCircle(percentage = progressCirclePercentage.toFloat())
        for(exam in exams){
            ProgressCard(
                title = exam.title,
                measure = exam.measure,
                message = exam.message,
                percentage = exam.percentage
            )
        }

    }
}


