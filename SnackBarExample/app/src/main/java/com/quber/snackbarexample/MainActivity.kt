package com.quber.snackbarexample

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
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.quber.snackbarexample.ui.theme.SnackBarExampleTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SnackBarExampleTheme {
                SnackBarExample(

                )
            }
        }
    }
}

@Composable
fun SnackBarExample() {

    val mySnackbarHostState = remember {
        SnackbarHostState()
    }

    val myCoroutineScope = rememberCoroutineScope()

    val myContext = LocalContext.current

    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = mySnackbarHostState,
            ) {
                Snackbar(
                    snackbarData = it,
//                    containerColor = Color.Red,
//                    contentColor = Color.White,
//                    actionColor = Color.Black,
//                    actionContentColor = Color.Black,
//                    dismissActionContentColor = Color.Blue,
                )
            }
        },
        content = { contentPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(
                    onClick = {
                        myCoroutineScope.launch {
                            val result = mySnackbarHostState.showSnackbar(
                                message = "This is the snackBar message",
                                actionLabel = "SHOWwww Toast",
                                duration = SnackbarDuration.Indefinite,
                                withDismissAction = true,
                            )

                            if (result == SnackbarResult.ActionPerformed)
                                Toast.makeText(myContext, "Action Performed", Toast.LENGTH_SHORT)
                                    .show()
                        }
                    }
                ) {
                    Text(
                        text = "Show SnackBar Message"
                    )
                }
            }
        },

        )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnackBarExampleTheme {
        SnackBarExample()
    }
}