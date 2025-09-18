package com.quber.toastmessageexample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.quber.toastmessageexample.ui.theme.ToastMessageExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToastMessageExampleTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {

    val myContext = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = {
                Toast.makeText(
                    myContext,
                    "This is a toast message",
                    Toast.LENGTH_SHORT,
                ).show()
            },
        ) {
            Text(
                text = "Show Toast Message",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToastMessageExampleTheme {
        Greeting()
    }
}