package com.rsschool.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.rsschool.quiz.contract.Navigator
import com.rsschool.quiz.contract.navigator
import com.rsschool.quiz.databinding.FragmentQuiz6Binding
import com.rsschool.quiz.databinding.FragmentResultBinding

class FragmentQuizSix : Fragment() {
    private lateinit var binding: FragmentQuiz6Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuiz6Binding.inflate(inflater, container, false)
        binding.questionTextView.text = requireArguments().getString(FragmentQuizSix.ARG_QUESTION_VALUE)
        binding.optionOne.text = requireArguments().getString(FragmentQuizSix.ARG_ANSWER1_VALUE)
        binding.optionTwo.text = requireArguments().getString(FragmentQuizSix.ARG_ANSWER2_VALUE)
        binding.optionThree.text = requireArguments().getString(FragmentQuizSix.ARG_ANSWER3_VALUE)
        binding.optionFour.text = requireArguments().getString(FragmentQuizSix.ARG_ANSWER4_VALUE)
        binding.optionFive.text = requireArguments().getString(FragmentQuizSix.ARG_ANSWER5_VALUE)
        binding.previousButton.setOnClickListener { navigator().goBack() }
        //binding.submitButton.isEnabled = false


        binding.submitButton.setOnClickListener{
            val checkRadioButtonID = binding.radioGroup.checkedRadioButtonId
            val answer = binding.radioGroup.findViewById<RadioButton>(checkRadioButtonID)
            val previousString = "Ваш ответ ${answer.text}"
            binding.previousTextView.text = previousString
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(question: String, answer1: String, answer2: String, answer3: String, answer4: String, answer5: String): FragmentQuizSix {
            val args = Bundle().apply {
                putString(ARG_QUESTION_VALUE, question)
                putString(ARG_ANSWER1_VALUE, answer1)
                putString(ARG_ANSWER2_VALUE, answer2)
                putString(ARG_ANSWER3_VALUE, answer3)
                putString(ARG_ANSWER4_VALUE, answer4)
                putString(ARG_ANSWER5_VALUE, answer5)
            }
            val fragment = FragmentQuizSix()
            //args.putInt(PREVIOUS_RESULT_KEY, previousResult)
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