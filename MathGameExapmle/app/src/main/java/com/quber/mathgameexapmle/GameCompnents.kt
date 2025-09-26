package com.quber.mathgameexapmle

import android.view.View.OnClickListener
import android.widget.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextForQuestion(text: String) {

    Text(
        text = text,
        fontSize = 20.sp,
        color = Color.White,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = colorResource(R.color.blue))
            .size(width = 300.dp, height = 75.dp)
            .wrapContentHeight(),
    )

}

@Composable
fun TextFieldForAnswer(text: MutableState<String>) {
    TextField(
        value = text.value,
        onValueChange = { text.value = it },
        label = { Text(text = "Enter your answer") },
        colors = TextFieldDefaults.colors(
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = colorResource(R.color.blue),
            unfocusedContainerColor = colorResource(R.color.ice_blue),
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.White,
            cursorColor = Color.White,
        ),
        modifier = Modifier.size(width = 300.dp, height = 75.dp),
        textStyle = TextStyle(
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
        ),
        shape = RoundedCornerShape(percent = 0),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

    )
}

@Composable
fun ButtonText(buttonText: String, onClick: () -> Unit, isEnable: Boolean) {
    Button(
        onClick = onClick,
        enabled = isEnable,
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        shape = RoundedCornerShape(size = 5.dp),
        border = BorderStroke(width = 2.dp, color = colorResource(id = R.color.blue)),
        modifier = Modifier.width(width = 150.dp),
    ) {
        Text(text = buttonText, fontSize = 20.sp, color = colorResource(R.color.blue))
    }
}