package com.quber.navigationexample

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SecondPage(navController: NavController, name: String, age: Int) {

    val userName = remember {
        mutableStateOf("")
    }

    val userAge = remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Second Page",
                        color = Color.White,
                        fontSize = 20.sp,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500),
                    navigationIconContentColor = Color.White,
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
//                            navController.navigate(route = "MainPage")
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Arrow Back",
                        )
                    }
                }
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
//                TextField(
//                    value = userName.value,
//                    onValueChange = { userName.value = it },
//                    label = { Text(text = "Enter your name") },
//                    colors = TextFieldDefaults.colors(
//                        focusedLabelColor = Color.White,
//                        unfocusedLabelColor = Color.White,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        focusedContainerColor = Color.Black,
//                        unfocusedContainerColor = colorResource(id = R.color.teal_700),
//                    ),
//                    modifier = Modifier.size(width = 300.dp, height = 60.dp),
//                    textStyle = TextStyle(
//                        fontSize = 18.sp,
//                        color = Color.White,
//                    ),
//                    shape = RoundedCornerShape(5.dp),
//                )
//
//                Spacer(modifier = Modifier.height(20.dp))
//
//                TextField(
//                    value = userAge.value,
//                    onValueChange = { userAge.value = it },
//                    label = { Text(text = "Enter your age") },
//                    colors = TextFieldDefaults.colors(
//                        focusedLabelColor = Color.White,
//                        unfocusedLabelColor = Color.White,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        focusedContainerColor = Color.Black,
//                        unfocusedContainerColor = colorResource(id = R.color.teal_700),
//                    ),
//                    modifier = Modifier.size(width = 300.dp, height = 60.dp),
//                    textStyle = TextStyle(
//                        fontSize = 18.sp,
//                        color = Color.White,
//                    ),
//                    shape = RoundedCornerShape(5.dp),
//                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//
//                    )
//
//                Spacer(modifier = Modifier.height(20.dp))
//
//                Button(
//                    onClick = {
//
//                    },
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Color.White,
//                    ),
//                    modifier = Modifier.size(width = 200.dp, height = 60.dp),
//                    shape = RoundedCornerShape(10.dp),
//                    border = BorderStroke(
//                        width = 2.dp,
//                        color = colorResource(id = R.color.teal_200)
//                    ),
//                ) {
//                    Text(
//                        text = "Send",
//                        color = colorResource(id = R.color.purple_500),
//                        fontSize = 25.sp,
//                    )
//                }
                Text(
                    text = "Name: $name",
                    color = Color.Black,
                    fontSize = 20.sp,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Age: $age",
                    color = Color.Black,
                    fontSize = 20.sp,
                )
            }
        }
    )
}