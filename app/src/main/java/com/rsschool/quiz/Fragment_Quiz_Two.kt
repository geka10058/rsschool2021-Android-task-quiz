package com.rsschool.quiz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rsschool.quiz.contract.navigator
import com.rsschool.quiz.databinding.FragmentQuiz1Binding
import com.rsschool.quiz.databinding.FragmentQuiz2Binding

class Fragment_Quiz_Two : Fragment() {
    private lateinit var binding: FragmentQuiz2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuiz2Binding.inflate(inflater, container, false)
        binding.questionTextView.text = requireArguments().getString(FragmentQuizOne.ARG_QUESTION_VALUE)!!
        binding.previousButton.setOnClickListener { navigator().goBack() }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(question: String): Fragment_Quiz_Two {
            val args = Bundle().apply {
                putString(ARG_QUESTION_VALUE, question)
            }
            val fragment = Fragment_Quiz_Two()
            //args.putInt(PREVIOUS_RESULT_KEY, previousResult)
            fragment.arguments = args
            return fragment
        }

        private const val ARG_QUESTION_VALUE = "Any_Question"
    }


}