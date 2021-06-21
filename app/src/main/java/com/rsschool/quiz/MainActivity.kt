package com.rsschool.quiz

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.rsschool.quiz.contract.Navigator
import com.rsschool.quiz.databinding.*
import java.util.ArrayList
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), Navigator {
    private lateinit var binding: ActivityMainBinding
    var answerList : ArrayList<String>  = arrayListOf("",":MKJBHG","","","","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        var answers = mutableListOf<String>()
        if (savedInstanceState == null) {
            val fragment =
                FragmentQuizOne.newInstance(
                    "Вопрос 1","Парильный ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 5"
                )
            supportFragmentManager.beginTransaction().add(R.id.flFragment, fragment).commit()
        }

    }

    private fun launchFragment (fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.flFragment, fragment)
            .commit()
    }

    override fun printAnswers() :String {
        return "${answerList[2]} ${answerList[3]}"
    }

    override fun addData(num : Int, str: String) {
        answerList[num].replace(answerList[num], str, false)
    }

    override fun goToFragmentQuizTwo() {
        launchFragment(FragmentQuizTwo.newInstance("Вопрос 2","Правильный ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 5"))
    }

    override fun goToFragmentQuizThree() {
        launchFragment(FragmentQuizThree.newInstance("Вопрос 3","Ответ 1", "Ответ 2", "Правильный ответ 3", "Ответ 4", "Ответ 5"))
    }

    override fun goToFragmentQuizFour() {
        launchFragment(FragmentQuizFour.newInstance("Вопрос 4","Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Правильный ответ"))
    }

    override fun goToFragmentQuizFive() {
        launchFragment(FragmentQuizFive.newInstance("Вопрос 5","Правильный ответ", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 5"))
    }

    override fun goToFragmentQuizSix() {
        launchFragment(FragmentQuizSix.newInstance("Вопрос 6","Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Правильный ответ 5"))
    }

    override fun goToFragmentResult() {
        launchFragment(FragmentQuizResult.newInstance("жьщтш"))
    }

    override fun goBack() {
        onBackPressed()
    }

    override fun goToMenu() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun finish() {
        exitProcess(-1)
    }


    /*private fun openFirstQuestionFragment(){
        binding1 = FragmentQuiz1Binding.inflate(layoutInflater)
        val view = binding1.root
        setContentView(view)


        val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        Log.d(",,,", "errr")
        fragmentOne: FragmentQuizOne = FragmentQuizOne.newInstance
            Log.d(",,,", "not errr")
            fragmentTransaction.replace(R.id.flFragment, fragmentOne).commit()
    }*/

    /* private fun openSecondQuestionFragment(){
         binding2 = FragmentQuiz2Binding.inflate(layoutInflater)
         val view = binding2.root
         setContentView(view)
     }

     private fun openThreeQuestionFragment(){
         binding3 = FragmentQuiz3Binding.inflate(layoutInflater)
         val view = binding3.root
         setContentView(view)
     }

     private fun openFourQuestionFragment(){
         binding4 = FragmentQuiz4Binding.inflate(layoutInflater)
         val view = binding4.root
         setContentView(view)
     }*/

    /* override fun onButtonNextPerformed() {
         openSecondQuestionFragment()
     }*/

}

