package com.rsschool.quiz.contract

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
}