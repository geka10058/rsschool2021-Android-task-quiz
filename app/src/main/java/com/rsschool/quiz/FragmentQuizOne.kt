package com.rsschool.quiz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.rsschool.quiz.contract.navigator
import com.rsschool.quiz.databinding.FragmentQuiz1Binding

open class FragmentQuizOne : Fragment(){
    private lateinit var binding : FragmentQuiz1Binding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentQuiz1Binding.inflate(inflater, container, false)
        binding.questionTextView.text = requireArguments().getString(ARG_QUESTION_VALUE)!!
        binding.nextButton.setOnClickListener{
            navigator().goToFragmentQuizTwo()//Toast.makeText(activity,R.string.toast_button_not_selected, Toast.LENGTH_LONG).show()
        }
        binding.previousButton.isEnabled = false




        binding.root
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(question: String): FragmentQuizOne {
            val args = Bundle().apply {
                putString(ARG_QUESTION_VALUE, question)
            }
            val fragment = FragmentQuizOne()
            //args.putInt(PREVIOUS_RESULT_KEY, previousResult)
            fragment.arguments = args
            return fragment
        }

        const val ARG_QUESTION_VALUE = "Any_Question"
    }

    /*override fun onButtonNextPerformed() {
        TODO("Not yet implemented")
        binding2 = FragmentQuiz2Binding.inflate(layoutInflater)
        val view = binding2.root
        setC
    }*/

    /*override fun onButtonNextPerformed() {
        binding2 = FragmentQuiz2Binding.inflate(layoutInflater)
        val view = binding2.root
    }*/


    /* companion object{
         @JvmStatic
         fun newInstance():Fragment_Question_One{
             val fragment = Fragment_Question_One()
             var args = Bundle()
             fragment.arguments = args
             return fragment
         }

     }*/

    /*interface ClickButtonNextListener {
        fun onButtonNextPerformed()
    }*/


}