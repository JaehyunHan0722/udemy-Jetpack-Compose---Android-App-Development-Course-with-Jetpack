package com.quber.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quber.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTestTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }

            }
        }
    }
}

//@Composable
//fun MyAlignment() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
////        contentAlignment = Alignment.Center
//    ) {
//
//        Text(
//            text = "Hello",
//            color = Color.White,
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold,
//            fontStyle = FontStyle.Italic,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .background(Color.Red)
//                .padding(
//                    start = 5.dp,
//                    end = 3.dp,
//                    top = 1.dp,
//                    bottom = 10.dp
//                )
//        )
//        Spacer(
//            modifier = Modifier
//                .size(20.dp)
//        )
//        Text(
//            text = "Andorid",
//            color = Color.White,
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold,
//            fontStyle = FontStyle.Italic,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .background(Color.Red)
//                .width(100.dp)
//        )
//        Spacer(
//            modifier = Modifier
//                .size(20.dp)
//        )
//        Text(
//            text = "Kotlin",
//            color = Color.White,
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold,
//            fontStyle = FontStyle.Italic,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .background(Color.Red)
//                .width(100.dp)
//        )
//    }
//}

@Composable
fun Home() {
    Box(
        modifier = Modifier
            .size(1920.dp, 1080.dp)
            .background(Color.Black)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
        ) {
            Text(
                text = "14:30",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
        }
    }
}


@Composable
fun Greeting(name: String) {

}

@Composable
fun MyLayout(name: String) {
    Column {
        Box(
            modifier = Modifier
                .background(
                    color = Color.Red
                )
                .width(200.dp)
                .height(100.dp)
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Blue)
                )

                Column {
                    Text(
                        text = "Hello $name!",
                        color = colorResource(id = R.color.black)
                    )
                    Text(
                        text = "Hello HHJ"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTestTheme {
//        MyLayout("Android")
//        MyAlignment()
        Home()
    }
}