package com.rsschool.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rsschool.quiz.contract.Navigator
import com.rsschool.quiz.databinding.*

class MainActivity : AppCompatActivity(), Navigator {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if (savedInstanceState == null) {
            val fragment =
                FragmentQuizOne.newInstance(
                    question = "Как думаете, мы успеем написать это говно и сдать?"
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

    override fun goToFragmentQuizTwo() {
        launchFragment(Fragment_Quiz_Two.newInstance(question = "Я ТОЖЕ В АХУЕ С ТОГО, ЧТО ЭТО РАБОТАЕТ"))
    }

    override fun goToFragmentQuizThree() {
        TODO("Not yet implemented")
    }

    override fun goToFragmentQuizFour() {
        TODO("Not yet implemented")
    }

    override fun goToFragmentQuizFive() {
        TODO("Not yet implemented")
    }

    override fun goToFragmentQuizSix() {
        TODO("Not yet implemented")
    }

    override fun goToFragmentResult() {
        TODO("Not yet implemented")
    }

    override fun goBack() {
        onBackPressed()
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

