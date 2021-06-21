package com.rsschool.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rsschool.quiz.contract.navigator
import com.rsschool.quiz.databinding.FragmentQuiz3Binding

class FragmentQuizThree : Fragment() {
    private lateinit var binding: FragmentQuiz3Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuiz3Binding.inflate(inflater, container, false)
        binding.questionTextView.text = requireArguments().getString(FragmentQuizThree.ARG_QUESTION_VALUE)
        binding.optionOne.text = requireArguments().getString(FragmentQuizThree.ARG_ANSWER1_VALUE)
        binding.optionTwo.text = requireArguments().getString(FragmentQuizThree.ARG_ANSWER2_VALUE)
        binding.optionThree.text = requireArguments().getString(FragmentQuizThree.ARG_ANSWER3_VALUE)
        binding.optionFour.text = requireArguments().getString(FragmentQuizThree.ARG_ANSWER4_VALUE)
        binding.optionFive.text = requireArguments().getString(FragmentQuizThree.ARG_ANSWER5_VALUE)
        binding.previousButton.setOnClickListener { navigator().goBack() }
        binding.nextButton.setOnClickListener{
            navigator().goToFragmentQuizFour()//Toast.makeText(activity,R.string.toast_button_not_selected, Toast.LENGTH_LONG).show()
        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(question: String, answer1: String, answer2: String, answer3: String, answer4: String, answer5: String): FragmentQuizThree {
            val args = Bundle().apply {
                putString(ARG_QUESTION_VALUE, question)
                putString(ARG_ANSWER1_VALUE, answer1)
                putString(ARG_ANSWER2_VALUE, answer2)
                putString(ARG_ANSWER3_VALUE, answer3)
                putString(ARG_ANSWER4_VALUE, answer4)
                putString(ARG_ANSWER5_VALUE, answer5)
            }
            val fragment = FragmentQuizThree()
            fragment.arguments = args
            return fragment
        }

        private const val ARG_QUESTION_VALUE = "Any_Question"
        private const val ARG_ANSWER1_VALUE = "answer1"
        private const val ARG_ANSWER2_VALUE = "answer2"
        private const val ARG_ANSWER3_VALUE = "answer3"
        private const val ARG_ANSWER4_VALUE = "answer4"
        private const val ARG_ANSWER5_VALUE = "answer5"
    }
}