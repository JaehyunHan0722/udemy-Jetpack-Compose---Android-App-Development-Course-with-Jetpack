package com.quber.mathgameexapmle

import android.os.CountDownTimer
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondPage(navController: NavController, category: String) {

    val myContext = LocalContext.current

    val systemUIController = rememberSystemUiController()
    systemUIController.setStatusBarColor(color = colorResource(R.color.blue))

    val life = remember { mutableIntStateOf(3) }
    val score = remember { mutableIntStateOf(0) }
    val remainingTime = remember { mutableIntStateOf(30) }
    val myQuestion = remember { mutableStateOf("") }
    val myAnswer = remember { mutableStateOf("") }
    val isEnabled = remember { mutableStateOf(true) }
    val focusManager = LocalFocusManager.current
    val correctAnswer = remember { mutableStateOf(0) }
    val totalTimeInMills = remember { mutableStateOf(30_000L) }

    val timer = remember {
        mutableStateOf(
            object : CountDownTimer(totalTimeInMills.value, 1_000L) {
                override fun onTick(millisUntilFinished: Long) {
                    remainingTime.intValue =
                        String.format(Locale.getDefault(), "%02d", millisUntilFinished / 1000)
                            .toInt()
                }

                override fun onFinish() {
                    cancel()
                    myQuestion.value = "TIME IS UP"
                    isEnabled.value = false
                    life.intValue -= 1
                }
            }.start()
        )
    }

    LaunchedEffect(
        key1 = "math",
        block = {
            val resultList = generateQuestion(category)
            myQuestion.value = resultList[0].toString()
            correctAnswer.value = resultList[1].toString().toInt()
        }
    )

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = stringResource(id = R.string.button_back)
                        )
                    }
                },
                title = {
                    Text(
                        text = category,
                        fontSize = 20.sp,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.blue),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                ),
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .paint(
                        painter = painterResource(id = R.drawable.second),
                        contentScale = ContentScale.FillBounds,
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(height = 20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Text(text = "Life: ", fontSize = 20.sp, color = Color.White)
                    Text(text = life.intValue.toString(), fontSize = 20.sp, color = Color.White)

                    Spacer(modifier = Modifier.width(width = 4.dp))

                    Text(text = "Score: ", fontSize = 20.sp, color = Color.White)
                    Text(text = score.intValue.toString(), fontSize = 20.sp, color = Color.White)

                    Spacer(modifier = Modifier.width(width = 4.dp))

                    Text(text = "Remaining Time: ", fontSize = 20.sp, color = Color.White)
                    Text(
                        text = remainingTime.intValue.toString(),
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(height = 30.dp))

                TextForQuestion(text = myQuestion.value)

                Spacer(modifier = Modifier.height(height = 15.dp))

                TextFieldForAnswer(text = myAnswer)

                Spacer(modifier = Modifier.height(height = 50.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ButtonText(
                        "OK",
                        onClick = {
                            focusManager.clearFocus(true)
                            if (myAnswer.value.isEmpty()) {
                                Toast.makeText(
                                    myContext,
                                    "Write an answer or click the Next Button",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                timer.value.cancel()

                                isEnabled.value = false
                                if (myAnswer.value.toInt() == correctAnswer.value) {
                                    score.intValue += 10
                                    myQuestion.value = "Congratulations"
                                    myAnswer.value = ""
                                } else {
                                    life.intValue -= 1
                                    myQuestion.value = "WRONG ANSWER"
                                }
                            }
                        },
                        isEnable = isEnabled.value
                    )
                    ButtonText(
                        "Next",
                        onClick = {
                            timer.value.cancel()
                            timer.value.start()

                            isEnabled.value = true
                            focusManager.clearFocus(true)
                            myAnswer.value = ""

                            if (life.intValue == 0) {
                                Toast.makeText(
                                    myContext,
                                    "GAME OVER",
                                    Toast.LENGTH_SHORT
                                ).show()
                                //MOVE ON TO GAME OVER PAGE
                                navController.navigate(
                                    route = "ResultPage/${score.intValue}",
                                    builder = {
                                        popUpTo(
                                            route = "FirstPage",
                                            popUpToBuilder = {
                                                inclusive = false
                                            },
                                        )
                                    })
                            } else {
                                val newResultList = generateQuestion(category)
                                myQuestion.value = newResultList[0].toString()
                                correctAnswer.value = newResultList[1].toString().toInt()
                            }
                        },
                        isEnable = true
                    )
                }
            }
        }
    )
}