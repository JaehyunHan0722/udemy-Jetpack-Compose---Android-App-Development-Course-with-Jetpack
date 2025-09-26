package com.quber.mathgameexapmle

import kotlin.random.Random

fun generateQuestion(selectedCategory: String): ArrayList<Any> {

    var numberOne = Random.nextInt(from = 0, until = 100)
    var numberTwo = Random.nextInt(from = 0, until = 100)

    val textQuestion: String
    val correctAnswer: Int

    when (selectedCategory) {
        "Addition" -> {
            textQuestion = "$numberOne + $numberTwo"
            correctAnswer = numberOne + numberTwo
        }

        "Subtraction" -> {
            if (numberOne >= numberTwo) {
                textQuestion = "$numberOne - $numberTwo"
                correctAnswer = numberOne - numberTwo
            } else {
                textQuestion = "$numberTwo - $numberOne"
                correctAnswer = numberTwo - numberOne
            }
        }

        "Multiplication" -> {
            numberOne = Random.nextInt(from = 0, until = 30)
            numberTwo = Random.nextInt(from = 0, until = 30)
            textQuestion = "$numberOne * $numberTwo"
            correctAnswer = numberOne * numberTwo
        }

        else -> {
            while (numberOne == 0 || numberTwo == 0) {
                numberOne = Random.nextInt(from = 0, until = 100)
                numberTwo = Random.nextInt(from = 0, until = 100)
            }
            textQuestion = "$numberOne / $numberTwo"
            correctAnswer = numberOne * numberTwo
        }
    }
    val gameResultList = ArrayList<Any>()
    gameResultList.add(textQuestion)
    gameResultList.add(correctAnswer)

    return gameResultList
}