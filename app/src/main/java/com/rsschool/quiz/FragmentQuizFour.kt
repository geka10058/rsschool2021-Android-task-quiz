package com.rsschool.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.rsschool.quiz.contract.navigator
import com.rsschool.quiz.databinding.FragmentQuiz4Binding

class FragmentQuizFour : Fragment() {
    private lateinit var binding: FragmentQuiz4Binding
    var test = ""
    var radioId = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentQuiz4Binding.inflate(inflater, container, false)
        binding.questionTextView.text = requireArguments().getString(FragmentQuizFour.ARG_QUESTION_VALUE)
        binding.optionOne.text = requireArguments().getString(FragmentQuizFour.ARG_ANSWER1_VALUE)
        binding.optionTwo.text = requireArguments().getString(FragmentQuizFour.ARG_ANSWER2_VALUE)
        binding.optionThree.text = requireArguments().getString(FragmentQuizFour.ARG_ANSWER3_VALUE)
        binding.optionFour.text = requireArguments().getString(FragmentQuizFour.ARG_ANSWER4_VALUE)
        binding.optionFive.text = requireArguments().getString(FragmentQuizFour.ARG_ANSWER5_VALUE)
        binding.nextButton.isEnabled = false

        checkId()

        binding.radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{
                group, checkedId -> val radio = binding.radioGroup.findViewById<RadioButton>(checkedId)
            test = radio.text.toString()
            radioId = checkedId
            navigator().addData(3, test)
            navigator().getId(3, radioId)
            binding.nextButton.isEnabled = true
        })

        binding.nextButton.setOnClickListener{
            navigator().goToFragmentQuizFive()//Toast.makeText(activity,R.string.toast_button_not_selected, Toast.LENGTH_LONG).show()
        }

        binding.previousButton.setOnClickListener {
            navigator().goBack() }
        binding.toolbar.setNavigationOnClickListener{
            navigator().goBack()
        }

        return binding.root
    }

    private fun checkId(){
        when (navigator().setId(3)){
            R.id.option_one.hashCode() -> {
                binding.optionOne.isChecked = true
                binding.nextButton.isEnabled = true
            }
            R.id.option_two.hashCode() -> {
                binding.optionTwo.isChecked = true
                binding.nextButton.isEnabled = true
            }
            R.id.option_three.hashCode() -> {
                binding.optionThree.isChecked = true
                binding.nextButton.isEnabled = true
            }
            R.id.option_four.hashCode() -> {
                binding.optionFour.isChecked = true
                binding.nextButton.isEnabled = true
            }
            R.id.option_five.hashCode() -> {
                binding.optionFive.isChecked = true
                binding.nextButton.isEnabled = true
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(question: String, answer1: String, answer2: String, answer3: String, answer4: String, answer5: String): FragmentQuizFour {
            val args = Bundle().apply {
                putString(ARG_QUESTION_VALUE, question)
                putString(ARG_ANSWER1_VALUE, answer1)
                putString(ARG_ANSWER2_VALUE, answer2)
                putString(ARG_ANSWER3_VALUE, answer3)
                putString(ARG_ANSWER4_VALUE, answer4)
                putString(ARG_ANSWER5_VALUE, answer5)
            }
            val fragment = FragmentQuizFour()
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