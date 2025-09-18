package com.quber.androidcomponents

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quber.androidcomponents.ui.theme.AndroidComponentsTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Components(

                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Components() {

    val buttonStatus = remember {
        mutableStateOf(true)
    }

    val buttonBackgroundColor = remember {
        mutableStateOf(Color.Red)
    }

    val myButtonText = remember {
        mutableStateOf("Do your Magic")
    }

    val myButtonTextColor = remember {
        mutableStateOf(Color.White)
    }

    val myText = remember {
        mutableStateOf("Hello World!")
    }

    val myTextColor = remember {
        mutableStateOf(Color.Black)
    }

    val valueOnTextField = remember {
        mutableStateOf("")
    }

    val userInput = remember {
        mutableStateOf("Result: ")
    }

    val myImage = remember {
        mutableStateOf(R.drawable.shared_image)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(
                id = myImage.value,
            ),
            contentDescription = "shared_image",
            modifier = Modifier
                .size(
                    width = 300.dp,
                    height = 300.dp
                )
                .background(Color.Black),
//            contentScale = ContentScale.FillBounds,
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center,
        )

        Spacer(
            modifier = Modifier
                .size(30.dp)
        )

        if (buttonStatus.value) {
            Text(
                text = myText.value,
                color = myTextColor.value,
                fontSize = 24.sp,
                modifier = Modifier
                    .background(Color.Red)
                    .padding(10.dp),
            )
        }
        Spacer(
            modifier = Modifier
                .size(30.dp)
        )

        Button(
            onClick = {
                buttonStatus.value = !buttonStatus.value
                if (buttonStatus.value) {
                    buttonBackgroundColor.value = Color.Black
                    myButtonText.value = "Do your Magic"
                    myButtonTextColor.value = Color.White
                    myText.value = "Hello World!"
                    myTextColor.value = Color.Black
                    myImage.value = R.drawable.shared_image
                } else {
                    buttonBackgroundColor.value = Color.Red
                    myButtonText.value = "Compose is fun"
                    myButtonTextColor.value = Color.White
                    myText.value = "Hello Compose!"
                    myTextColor.value = Color.White
                    myImage.value = R.drawable.ic_wifi
                }

                userInput.value = valueOnTextField.value
                valueOnTextField.value = ""
            },
            modifier = Modifier.size(
                width = 250.dp,
                height = 60.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonBackgroundColor.value
            ),
            shape = RoundedCornerShape(100),
            border = BorderStroke(
                width = 3.dp,
                color = Color.Black
            )
        ) {
            Text(
                text = myButtonText.value,
                color = myButtonTextColor.value,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
            )
        }

        Spacer(
            modifier = Modifier
                .size(30.dp)
        )

        TextField(
            value = valueOnTextField.value,
            onValueChange = {
                valueOnTextField.value = it
            },
            label = {
                Text(
                    text = "Enter your name",
                )
            },
            modifier = Modifier
                .width(300.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = Color.White,
                containerColor = Color.Blue,
                focusedLabelColor = Color.Yellow,
                unfocusedLabelColor = Color.White,
                unfocusedIndicatorColor = Color.Red,
                focusedIndicatorColor = Color.Green,
            ),
            textStyle = TextStyle.Default.copy(
                fontSize = 20.sp
            ),
            maxLines = 4,
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Number,
//            ),
//            visualTransformation = PasswordVisualTransformation()

        )

        Spacer(modifier = Modifier.size(30.dp))

        Text(
            text = userInput.value,
            color = myTextColor.value,
            fontSize = 24.sp,
            modifier = Modifier
                .background(Color.Red)
                .padding(10.dp),
        )

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidComponentsTheme {
        Components()
    }
}