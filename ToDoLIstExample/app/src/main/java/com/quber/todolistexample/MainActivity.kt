package com.quber.todolistexample

import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.quber.todolistexample.ui.theme.ToDoLIstExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoLIstExampleTheme {
                MainPage()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage() {

    val myContext = LocalContext.current
    val todoName = remember {
        mutableStateOf("")
    }
    val itemList = readData(myContext)
    val focusManager = LocalFocusManager.current
    val deleteDialogStatus = remember {
        mutableStateOf(false)
    }
    val clickedItemIndex = remember {
        mutableIntStateOf(0)
    }
    val updateDialogStatus = remember {
        mutableStateOf(false)
    }
    val clickedItem = remember {
        mutableStateOf("")
    }
    val isUpdated = remember {
        mutableStateOf(false)
    }
    val textDialogStatus = remember {
        mutableStateOf(false)
    }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            //Row for ADD new Item
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                TextField(
                    value = todoName.value,
                    onValueChange = {
                        todoName.value = it
                    },
                    label = { Text(text = "Enter TODO") },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedLabelColor = Color.Green,
                        unfocusedLabelColor = Color.White,
                        focusedContainerColor = MaterialTheme.colorScheme.primary,
                        unfocusedContainerColor = MaterialTheme.colorScheme.primary,
                        unfocusedTextColor = Color.White,
                        focusedTextColor = Color.Blue,
                        cursorColor = Color.Red,
                    ),
                    shape = RoundedCornerShape(size = 5.dp),
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(size = 5.dp)
                        )
                        .weight(weight = 7f)
                        .height(height = 60.dp),
                    textStyle = TextStyle(textAlign = TextAlign.Center),
                )

                Spacer(modifier = Modifier.width(5.dp))

                //ADD Button
                Button(
                    onClick = {
                        if (todoName.value.isNotEmpty()) {
                            itemList.add(todoName.value)
                            writeData(itemList, myContext)
                            todoName.value = ""
                            focusManager.clearFocus()
                        } else {
                            Toast.makeText(myContext, "Please enter what to do", Toast.LENGTH_SHORT)
                                .show()
                        }
                    },
                    modifier = Modifier
                        .weight(weight = 3f)
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.green),
                        contentColor = Color.White,
                    ),
                    shape = RoundedCornerShape(size = 5.dp),
                    border = BorderStroke(width = 1.dp, color = Color.Black),
                ) {
                    Text(
                        text = "Add",
                        fontSize = 20.sp
                    )
                }
            }

            //Column that shows added items
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 7.dp)
                    .clickable(
                        enabled = true,
                        onClick = {
                            focusManager.clearFocus()
                        }
                    )
            ) {
                items(
                    count = itemList.size,
                    itemContent = {
                        val item = itemList[it]

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 2.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = Color.White,
                            ),
                            shape = RoundedCornerShape(percent = 0),
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Text(
                                    text = item,
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier
                                        .width(300.dp)
                                        .clickable {
                                            clickedItem.value = item
                                            textDialogStatus.value = true
                                        }
                                )
                                Row(

                                ) {
                                    //Button EDIT
                                    IconButton(
                                        onClick = {
                                            updateDialogStatus.value = true
                                            clickedItemIndex.intValue = it
                                            clickedItem.value = item
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.Edit,
                                            contentDescription = "edit",
                                            tint = Color.White,
                                        )
                                    }
                                    //Button DELETE
                                    IconButton(
                                        onClick = {
//                                            itemList.remove(item)
//                                            writeData(itemList, myContext)
                                            deleteDialogStatus.value = true
                                            clickedItemIndex.intValue = it
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.Delete,
                                            contentDescription = "delete",
                                            tint = Color.White,
                                        )
                                    }
                                }
                            }
                        }
                    }
                )
            }

            if (deleteDialogStatus.value) {
                AlertDialog(
                    onDismissRequest = {
                        deleteDialogStatus.value = false
                    },
                    title = { Text(text = "Delete") },
                    text = { Text(text = "Do you want to delete the item from the list?") },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                Toast.makeText(
                                    myContext,
                                    "'${itemList[clickedItemIndex.value]}' is removed from the list",
                                    Toast.LENGTH_SHORT
                                ).show()
                                itemList.removeAt(clickedItemIndex.value)
                                writeData(itemList, myContext)
                                deleteDialogStatus.value = false
                            },
                        ) {
                            Text(text = "Yes")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                deleteDialogStatus.value = false
                            }
                        ) {
                            Text(text = "No")
                        }
                    }
                )
            }

            if (updateDialogStatus.value) {
                AlertDialog(
                    onDismissRequest = {
//                        updateDialogStatus.value = false
                    },
                    title = { Text(text = "Update") },
                    text = {
                        TextField(
                            value = clickedItem.value,
                            onValueChange = { changedValue ->
                                clickedItem.value = changedValue

                                isUpdated.value = clickedItem.value == changedValue
                            }
                        )
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                Toast.makeText(
                                    myContext,
                                    "'Item is updated",
                                    Toast.LENGTH_SHORT
                                ).show()
                                itemList[clickedItemIndex.intValue] = clickedItem.value
                                writeData(itemList, myContext)
                                updateDialogStatus.value = false
                                isUpdated.value = false
                            },
                            enabled = isUpdated.value
                        ) {
                            Text(text = "Yes")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                updateDialogStatus.value = false
                                isUpdated.value = false
                            }
                        ) {
                            Text(text = "No")
                        }
                    }
                )
            }

            if (textDialogStatus.value) {
                AlertDialog(
                    onDismissRequest = {
                        textDialogStatus.value = false
                    },
                    title = { Text(text = "TODO Item") },
                    text = {
                        Text(text = clickedItem.value)
                    },
                    confirmButton = {
                        TextButton(
                            onClick = { textDialogStatus.value = false },
                        ) {
                            Text(text = "Ok")
                        }
                    },
                )
            }
        }
    }
}