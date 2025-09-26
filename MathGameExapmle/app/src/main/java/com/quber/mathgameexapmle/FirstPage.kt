package com.quber.mathgameexapmle

import androidx.annotation.ColorRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstPage(navController: NavController) {

    val systemUIController = rememberSystemUiController()
    systemUIController.setStatusBarColor(color = colorResource(R.color.green))

    val category = stringArrayResource(R.array.category)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Math Game",
                        fontSize = 20.sp,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.green),
                    titleContentColor = Color.White,
                ),
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .paint(
                        painter = painterResource(id = R.drawable.first),
                        contentScale = ContentScale.FillBounds,
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                for(type in category) {
                    Button(
                        onClick = {
                            navController.navigate(route = "SecondPage/$type")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.green),
                        ),
                        shape = RoundedCornerShape(size = 20.dp),
                        modifier = Modifier.size(width = 250.dp, height = 100.dp,)
                    ) {
                        Text(
                            text = type,
                            color = Color.White,
                            fontSize = 20.sp,
                        )
                    }
                }

//                Button(
//                    onClick = {
//                        navController.navigate(route = "SecondPage/add")
//                    },
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = colorResource(R.color.green),
//                    ),
//                    shape = RoundedCornerShape(size = 20.dp),
//                    modifier = Modifier.size(width = 250.dp, height = 100.dp,)
//                ) {
//                    Text(
//                        text = "Addition",
//                        color = Color.White,
//                        fontSize = 20.sp,
//                    )
//                }
//                Button(
//                    onClick = {
//                        navController.navigate(route = "SecondPage/sub")
//                    },
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = colorResource(R.color.green),
//                    ),
//                    shape = RoundedCornerShape(size = 20.dp),
//                    modifier = Modifier.size(width = 250.dp, height = 100.dp,)
//                ) {
//                    Text(
//                        text = "Subtraction",
//                        color = Color.White,
//                        fontSize = 20.sp,
//                    )
//                }
//                Button(
//                    onClick = {
//                        navController.navigate(route = "SecondPage/multi")
//                    },
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = colorResource(R.color.green),
//                    ),
//                    shape = RoundedCornerShape(size = 20.dp),
//                    modifier = Modifier.size(width = 250.dp, height = 100.dp,)
//                ) {
//                    Text(
//                        text = "Multiplication",
//                        color = Color.White,
//                        fontSize = 20.sp,
//                    )
//                }
//                Button(
//                    onClick = {
//                        navController.navigate(route = "SecondPage/div")
//                    },
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = colorResource(R.color.green),
//                    ),
//                    shape = RoundedCornerShape(size = 20.dp),
//                    modifier = Modifier.size(width = 250.dp, height = 100.dp,)
//                ) {
//                    Text(
//                        text = "Division",
//                        color = Color.White,
//                        fontSize = 20.sp,
//                    )
//                }
            }
        }
    )
}