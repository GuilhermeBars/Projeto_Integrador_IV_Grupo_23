package com.example.docnow

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.docnow.ui.theme.Amarelo
import com.example.docnow.ui.theme.Amarelo2
import com.example.docnow.ui.theme.Azul
import com.example.docnow.ui.theme.Azul2
import com.example.docnow.ui.theme.Preto
import com.example.docnow.ui.theme.Vermelho
import com.example.docnow.ui.theme.Vermelho2
import com.example.docnow.ui.theme.VermelhoB
import java.util.Calendar

@Composable
fun UnderlineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isPassword: Boolean,
    enable: Boolean
) {
    var isVisible by remember { mutableStateOf(false) }
    var textFieldColors = TextFieldDefaults.colors(
        focusedTextColor = Color.Black,
        unfocusedTextColor = Color.Black,
        disabledTextColor = Color.LightGray,
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,
        focusedIndicatorColor = Color.Gray,
        unfocusedIndicatorColor = Color.Gray,
        disabledIndicatorColor = Color.Transparent)

    if (!enable){
        textFieldColors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            disabledTextColor = Color.DarkGray,
            focusedContainerColor = Color.LightGray,
            unfocusedContainerColor = Color.LightGray,
            disabledContainerColor = Color.LightGray,
            focusedIndicatorColor = Color.Gray,
            unfocusedIndicatorColor = Color.Gray,
            disabledIndicatorColor = Color.LightGray)
    }

    val textStyle = TextStyle(
        color = Color.Black,
        fontWeight = FontWeight.Bold
    )

    val labelComposable = @Composable {
        Text(
            label,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
    }



    if(isPassword){
        TextField(
            value = value,
            enabled = enable,
            onValueChange = onValueChange,
            label = labelComposable,
            colors = textFieldColors,
            textStyle = textStyle,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 30.dp),
            visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (isVisible)
                    Icons.Default.Visibility
                else
                    Icons.Default.VisibilityOff

                IconButton(onClick = { isVisible = !isVisible }) {
                    Icon(imageVector = image, contentDescription = null)
                }
            }
        )
    } else {
        TextField(
            enabled = enable,
            value = value,
            onValueChange = onValueChange,
            label = labelComposable,
            colors = textFieldColors,
            textStyle = textStyle,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 30.dp)
        )
    }

}

@Composable
fun ButtonDefault(
    label: String,
    color1: Color,
    color2: Color,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = color1,
            contentColor = color2
        ),
        shape = RoundedCornerShape(16),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 90.dp)
            .shadow(
                elevation = 9.dp,
                shape = RoundedCornerShape(16)
            )
    ) {Text(label) }
}

@Composable
fun ProgressCircle (
    percentage: Float,
    radius: Dp = 50.dp,
    strokeWidth: Dp = 5.dp,

    ){
    var mainColor by remember { mutableStateOf(Preto) }

    mainColor = if (percentage < 33){
        Vermelho
    }
    else if (percentage < 66){
        Amarelo
    }
    else{
        Azul

    }

    Box(
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            for (i in 1..4) {
                drawArc(
                    color = Color.Black.copy(alpha = 0.5f),
                    -90f,
                    360 * percentage/100,
                    useCenter = false,
                    style = Stroke((strokeWidth + (i * 2.5).dp).toPx(), cap = StrokeCap.Round),
                    alpha = 0.3f / i
                )
            }

            drawArc(
                color = mainColor,
                -90f,
                360 * percentage/100,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round),
            )
        }
        Text(
            text = ((percentage).toInt().toString() + "/100"),
            color = mainColor,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold

        )

    }
}

@Composable
fun ProgressCard(
    title: String,
    measure: String,
    message: String,
    percentage: Float,

){
    var mainColor by remember { mutableStateOf(Preto) }
    var secondaryColor by remember { mutableStateOf(Preto) }
    var borderColor by remember { mutableStateOf(Preto) }
    val textColor by remember { mutableStateOf(Preto) }

    if (percentage < 33){
        mainColor = Vermelho
        secondaryColor = Vermelho2
        borderColor = VermelhoB
    }
    else if (percentage < 66){
        mainColor =  Amarelo
        secondaryColor = Amarelo2
        borderColor = Amarelo
    }
    else{
        mainColor =  Azul
        secondaryColor = Azul2
        borderColor = Azul

    }


    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = secondaryColor),
        border = BorderStroke(1.dp, borderColor),
        modifier = Modifier
            .padding(vertical = 10.dp)
            .size(width = 385.dp, height = 125.dp)
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(8.dp),
                clip = false,
                ambientColor = Color.Black.copy(alpha = 0.5f),
                spotColor = Color.Black.copy(alpha = 0.2f)
            )

    ) {
        Row (
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            ProgressCircle(percentage = percentage)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 30.dp)
            ){
                Text(
                    text = title,
                    color = textColor,
                    modifier = Modifier
                        .padding(bottom = 0.5.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = measure,
                    color = textColor,
                    modifier = Modifier
                        .padding(bottom = 5.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp
                )
                Text(
                    text = message,
                    color = textColor,
                    modifier = Modifier
                        .widthIn(max = 175.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
            }
        }


    }
}

@Composable
fun BackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .size(48.dp)
            .padding(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Voltar",
            tint = Azul,
            modifier = Modifier.size(24.dp)
        )
    }
}

