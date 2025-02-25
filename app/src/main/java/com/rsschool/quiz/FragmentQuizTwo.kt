package com.rsschool.quiz

import android.app.ActionBar
import android.os.Bundle
import android.view.*
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.rsschool.quiz.contract.navigator
import com.rsschool.quiz.databinding.FragmentQuiz1Binding
import com.rsschool.quiz.databinding.FragmentQuiz2Binding

class FragmentQuizTwo : Fragment() {
    //private lateinit var binding: FragmentQuiz2Binding
    private var _binding: FragmentQuiz2Binding? = null
    private val binding get() = _binding!!
    var test = ""
    var radioId = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuiz2Binding.inflate(inflater, container, false)

        binding.questionTextView.text = requireArguments().getString(FragmentQuizTwo.ARG_QUESTION_VALUE)
        binding.optionOne.text = requireArguments().getString(FragmentQuizTwo.ARG_ANSWER1_VALUE)
        binding.optionTwo.text = requireArguments().getString(FragmentQuizTwo.ARG_ANSWER2_VALUE)
        binding.optionThree.text = requireArguments().getString(FragmentQuizTwo.ARG_ANSWER3_VALUE)
        binding.optionFour.text = requireArguments().getString(FragmentQuizTwo.ARG_ANSWER4_VALUE)
        binding.optionFive.text = requireArguments().getString(FragmentQuizTwo.ARG_ANSWER5_VALUE)
        binding.nextButton.isEnabled = false

        checkId()

        binding.radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{
                group, checkedId -> val radio = binding.radioGroup.findViewById<RadioButton>(checkedId)
            test = radio.text.toString()
            radioId = checkedId
            navigator().addData(1, test)
            navigator().getId(1, radioId)
            binding.nextButton.isEnabled = true
        })

        binding.nextButton.setOnClickListener{
            navigator().goToFragmentQuizThree()//Toast.makeText(activity,R.string.toast_button_not_selected, Toast.LENGTH_LONG).show()
        }

        binding.previousButton.setOnClickListener {
            navigator().goBack() }
        binding.toolbar.setNavigationOnClickListener{
            navigator().goBack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun checkId(){
        when (navigator().setId(1)){
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
        fun newInstance(question: String, answer1: String, answer2: String, answer3: String, answer4: String, answer5: String): FragmentQuizTwo {
            val args = Bundle().apply {
                putString(ARG_QUESTION_VALUE, question)
                putString(ARG_ANSWER1_VALUE, answer1)
                putString(ARG_ANSWER2_VALUE, answer2)
                putString(ARG_ANSWER3_VALUE, answer3)
                putString(ARG_ANSWER4_VALUE, answer4)
                putString(ARG_ANSWER5_VALUE, answer5)
            }
            val fragment = FragmentQuizTwo()
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