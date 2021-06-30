package com.rsschool.quiz

import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.rsschool.quiz.contract.navigator
import com.rsschool.quiz.databinding.FragmentQuiz2Binding

class FragmentQuizTwo : Fragment() {
    private lateinit var binding: FragmentQuiz2Binding
    //lateinit var viewModel: TestViewModel
    var test = ""
    var radioId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuiz2Binding.inflate(inflater, container, false)
        //viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        binding.questionTextView.text = requireArguments().getString(FragmentQuizTwo.ARG_QUESTION_VALUE)
        binding.optionOne.text = requireArguments().getString(FragmentQuizTwo.ARG_ANSWER1_VALUE)
        binding.optionTwo.text = requireArguments().getString(FragmentQuizTwo.ARG_ANSWER2_VALUE)
        binding.optionThree.text = requireArguments().getString(FragmentQuizTwo.ARG_ANSWER3_VALUE)
        binding.optionFour.text = requireArguments().getString(FragmentQuizTwo.ARG_ANSWER4_VALUE)
        binding.optionFive.text = requireArguments().getString(FragmentQuizTwo.ARG_ANSWER5_VALUE)
        binding.nextButton.isEnabled = false

        binding.radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{
                group, checkedId -> val radio = binding.radioGroup.findViewById<RadioButton>(checkedId)
            radioId = checkedId
            test = radio.text.toString()
            //Toast.makeText(context," On checked change : ${radio.text}", Toast.LENGTH_SHORT).show()
            binding.nextButton.isEnabled = true
        })

        binding.nextButton.setOnClickListener{
            navigator().addData(1, test)
            //viewModel.owner2 = test
            //navigator().printAnswers()
            navigator().goToFragmentQuizThree()//Toast.makeText(activity,R.string.toast_button_not_selected, Toast.LENGTH_LONG).show()
        }

        binding.previousButton.setOnClickListener {
            navigator().goBack() }
        binding.toolbar.setNavigationOnClickListener{
            navigator().goBack()
        }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.run {
            putInt(BUTTON_SELECTED, radioId)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        if (savedInstanceState != null) {

        }

        //binding.radioGroup.checkedRadioButtonI = savedInstanceState.hashCode()
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
        private const val BUTTON_SELECTED = "selected"
        private var selected = -1
    }


}