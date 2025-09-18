package com.quber.lazycolumnexapmle

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.quber.lazygridexapmle.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondPage(navController: NavController, id: Int) {

    val country = retrieveCountries()[id - 1]

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        },
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "arrow back",
                        )
                    }
                },
                title = {
                    Text(
                        text = "Details"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.purple_700),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.Black,
                ),

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
                Image(
                    painter = painterResource(id = country.countryImage),
                    contentDescription = country.countryName,
                    modifier = Modifier
                        .size(width = 350.dp, height = 250.dp)
                        .border(width = 2.dp, color = Color.Black),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center,
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = country.countryName,
                    color = Color.Black,
                    fontSize = 24.sp,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = country.countryDetail,
                    color = Color.Blue,
                    fontSize = 20.sp,
                )
            }
        }
    )
}
