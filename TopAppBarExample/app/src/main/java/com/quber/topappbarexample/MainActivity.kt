package com.quber.topappbarexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.quber.topappbarexample.ui.theme.TopAppBarExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TopAppBarExampleTheme {
                TopAppBarExample(

                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample() {

    val actionText = remember {
        mutableStateOf("Actions will be shown here")
    }

    val menuStatus = remember {
        mutableStateOf(false)
    }

    val dropDownStatus = remember {
        mutableStateOf(false)
    }


    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            actionText.value = "Navigation icon is clicked"
                        },
                    ) {
                        Icon(
                            Icons.Filled.Menu,
                            contentDescription = "",
                        )
                    }
                },
                title = {
                    Column {
                        Text(
                            text = stringResource(R.string.app_name),
                            color = Color.White,
                            fontSize = 20.sp,
                        )
                        Text(
                            text = "Subtitle",
                            color = Color.White,
                            fontSize = 16.sp,
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            actionText.value = "Share icon is clicked"
                        },
                    ) {
                        Icon(
                            Icons.Filled.Share,
                            contentDescription = "Share Icon",
                        )
                    }
                    IconButton(
                        onClick = {
                            actionText.value = "Search icon is clicked"
                        },
                    ) {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = "Search Icon",
                        )
                    }
                    IconButton(
                        onClick = {
                            actionText.value = "More icon is clicked"
                            menuStatus.value = !menuStatus.value
                        },
                    ) {
                        Icon(
                            Icons.Filled.MoreVert,
                            contentDescription = "More Icon",
                        )

                        DropdownMenu(
                            expanded = menuStatus.value,
                            onDismissRequest = {
                                menuStatus.value = false
                            }
                        ) {
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = "Settings"
                                    )
                                },
                                onClick = {
                                    menuStatus.value = false
                                    actionText.value = "Settings is Clicked"
                                }
                            )
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = "Logout"
                                    )
                                },
                                onClick = {
                                    menuStatus.value = false
                                    actionText.value = "Logout is Clicked"
                                }
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(
                        id = R.color.purple_200,
                    ),
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.Red,
                    scrolledContainerColor = Color.Red,
                )
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = actionText.value,
                    color = Color.Black,
                    fontSize = 18.sp,
                )
            }
        },
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TopAppBarExampleTheme {
        TopAppBarExample()
    }
}