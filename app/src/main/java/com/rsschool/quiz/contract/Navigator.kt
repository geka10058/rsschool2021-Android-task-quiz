package com.rsschool.quiz.contract

import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator

}

interface Navigator {

    fun goToFragmentQuizTwo()

    fun goToFragmentQuizThree()

    fun goToFragmentQuizFour()

    fun goToFragmentQuizFive()

    fun goToFragmentQuizSix()

    fun goToFragmentResult()

    fun goBack()

    fun addData(num : Int,str: String)

    fun printResaltOfQuiz():String

    fun goToMenu()

    fun finish()

    fun createEmailReport():String

    fun resetCounters()

    fun shareToEmail()

}