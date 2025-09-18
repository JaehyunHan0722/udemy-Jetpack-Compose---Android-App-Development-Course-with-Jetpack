package com.quber.swtichexamle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.provider.FontsContractCompat.Columns
import com.quber.swtichexamle.ui.theme.SwtichExamleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SwtichExamleTheme {
                SwitchExample()
            }
        }
    }
}

@Composable
fun SwitchExample() {

    val checked = remember {
        mutableStateOf(false)
    }

    val myText = remember {
//        if (checked.value)
//            mutableStateOf("visible")
//        else
//            mutableStateOf("invisible")
//        mutableStateOf(if (checked.value) "visible" else "invisible")
        mutableStateOf("The image is invisible")
    }

    val myAlpha = remember {
        mutableStateOf(1f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(
            modifier = Modifier.size(50.dp),
        )

        Switch(
            checked = checked.value,
            onCheckedChange = {
                checked.value = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Blue,
                checkedTrackColor = Color.Red,
                uncheckedThumbColor = Color.Red,
                uncheckedTrackColor = Color.Blue
            ),
        )

        Spacer(
            modifier = Modifier.size(30.dp),
        )

        if (!checked.value) {
            myText.value = "The image is visible"
            myAlpha.value = 1f
        } else {
//            Spacer(
//                modifier = Modifier.size(
//                    300.dp,
//                )
//            )
            myAlpha.value = 0f
            myText.value = "The image is invisible"
        }

        Image(
            painter = painterResource(
                id = R.drawable.test_image,
            ),
            contentDescription = "",
            modifier = Modifier
                .size(300.dp)
                .alpha(myAlpha.value),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center,
        )

//        Image(
//            painter = painterResource(
//                id = R.drawable.test_image,
//            ),
//            contentDescription = "",
//            modifier = Modifier
//                .size(300.dp)
//                .alpha(if (checked.value) 1f else 0f),
//            contentScale = ContentScale.Fit,
//            alignment = Alignment.Center,
//        )

        Spacer(
            modifier = Modifier.size(10.dp),
        )

        Text(
            text = myText.value,
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Blue)
                .width(300.dp)
                .padding(top = 10.dp, bottom = 10.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SwitchExample()
}