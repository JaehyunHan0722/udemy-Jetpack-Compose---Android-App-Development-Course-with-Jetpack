package com.quber.dropdown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quber.dropdown.ui.theme.DropdownTheme
import kotlinx.coroutines.selects.select

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DropdownTheme {
                Dropdown()
            }
        }
    }
}

@Composable
fun Dropdown() {

    val selectedItem = remember {
        mutableStateOf("Korea")
    }

    val dropdownStatus = remember {
        mutableStateOf(false)
    }

//    val items = listOf("Korea", "Japan", "China", "Germany", "USA", "New Zealand", "Australia", "France", "Russia", "Brazil", "Argentina", "Korea", "Japan", "China", "Germany", "USA", "New Zealand", "Australia", "France", "Russia", "Brazil", "Argentina")
    val items = stringArrayResource(R.array.country_list)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable {
                dropdownStatus.value = true
            }
        ) {
            Text(
                text = selectedItem.value,
                modifier = Modifier.clickable {
                    dropdownStatus.value = true
                }
            )
            Spacer(
                modifier = Modifier.size(10.dp)
            )

            Image(
                painter = painterResource(
                    id = R.drawable.baseline_arrow_drop_down_24,
                ),
                contentDescription = "dropdownArrow",
            )

            DropdownMenu(
                expanded = dropdownStatus.value,
                onDismissRequest = {
                    dropdownStatus.value = false
                }
            ) {
//                DropdownMenuItem(
//                    text = { Text("Korea") },
//                    onClick = {
//                        dropdownStatus.value = false
//                        selectedItem.value = "Korea"
//                    }
//                )
//                DropdownMenuItem(
//                    text = { Text("Japan") },
//                    onClick = {
//                        dropdownStatus.value = false
//                        selectedItem.value = "Japan"
//                    }
//                )
//                DropdownMenuItem(
//                    text = { Text("China") },
//                    onClick = {
//                        dropdownStatus.value = false
//                        selectedItem.value = "China"
//                    }
//                )

                for (i in items) {
                    DropdownMenuItem(
                        text = {
                            Text(i)
                        },
                        onClick = {
                            dropdownStatus.value = false
                            selectedItem.value = i
                        },
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DropdownTheme {
        Dropdown()
    }
}