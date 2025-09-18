package com.quber.lazycolumnexapmle

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.quber.lazylowexamle.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstPage(navController: NavController) {

    val countryList = retrieveCountries()
    val myContext = LocalContext.current
    val topAppBarBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(
            connection = topAppBarBehavior.nestedScrollConnection,
        ),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Countries", fontSize = 20.sp)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.purple_500),
                    titleContentColor = Color.White,
                    scrolledContainerColor = colorResource(R.color.teal_200),
                ),
                scrollBehavior = topAppBarBehavior,
            )
        },
        content = {
            //LazyRow
            LazyRow(
                modifier = Modifier.padding(it)
            ) {
                items(
                    count = countryList.count(),
                    itemContent = {
                        val country = countryList[it]

                        Card(
                            onClick = {
                                Toast.makeText(
                                    myContext,
                                    "You selected the ${country.countryName}",
                                    Toast.LENGTH_SHORT,
                                ).show()
                            },
                            modifier = Modifier
                                .width(170.dp)
                                .height(300.dp)
                                .padding(7.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = colorResource(R.color.purple_500),
                            ),
                            shape = RoundedCornerShape(10.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 30.dp),
                            border = BorderStroke(2.dp, color = Color.Red),
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(7.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ) {
                                    Image(
                                        painter = painterResource(id = country.countryImage),
                                        contentDescription = country.countryName,
                                        modifier = Modifier
                                            .size(80.dp)
                                            .clip(RoundedCornerShape(100))
                                            .border(
                                                width = 2.dp,
                                                color = Color.Red,
                                                shape = RoundedCornerShape(100)
                                            ),
                                        contentScale = ContentScale.Crop,
                                        alignment = Alignment.Center,
                                    )
                                    Column(
                                        modifier = Modifier.padding(top = 10.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                    ) {
                                        Text(
                                            text = country.countryName,
                                            fontSize = 20.sp,
                                            color = Color.White,
                                            textAlign = TextAlign.Center,
                                        )
                                        Spacer(modifier = Modifier.height(3.dp))
                                        Text(
                                            text = country.countryDetail,
                                            fontSize = 16.sp,
                                            color = Color.White,
                                            textAlign = TextAlign.Center,
                                        )
                                    }
                                }
                                Button(
                                    onClick = {
                                        navController.navigate("SecondPage/${country.countryId}")
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                                    border = BorderStroke(width = 2.dp, color = Color.Red),
                                ) {
                                    Icon(
                                        Icons.AutoMirrored.Rounded.ArrowForward,
                                        contentDescription = "Details",
                                        tint = Color.Red,
                                    )
                                }
                            }

                        }
                    }
                )
            }
        }
    )

}