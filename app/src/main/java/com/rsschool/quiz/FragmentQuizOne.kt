package com.rsschool.quiz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.rsschool.quiz.contract.navigator
import com.rsschool.quiz.databinding.FragmentQuiz1Binding
import android.widget.RadioGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get

open class FragmentQuizOne : Fragment(){
    private lateinit var binding : FragmentQuiz1Binding
    //lateinit var viewModel: TestViewModel
    var test = ""

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentQuiz1Binding.inflate(inflater, container, false)
        //viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        binding.questionTextView.text = requireArguments().getString(ARG_QUESTION_VALUE)
        binding.optionOne.text = requireArguments().getString(ARG_ANSWER1_VALUE)
        binding.optionTwo.text = requireArguments().getString(ARG_ANSWER2_VALUE)
        binding.optionThree.text = requireArguments().getString(ARG_ANSWER3_VALUE)
        binding.optionFour.text = requireArguments().getString(ARG_ANSWER4_VALUE)
        binding.optionFive.text = requireArguments().getString(ARG_ANSWER5_VALUE)
        binding.nextButton.isEnabled = false
        binding.previousButton.isEnabled = false

        binding.radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{
            group, checkedId -> val radio = binding.radioGroup.findViewById<RadioButton>(checkedId)
            test = radio.text.toString()
            //Toast.makeText(context," On checked change : ${radio.text}", Toast.LENGTH_SHORT).show()
            binding.nextButton.isEnabled = true
        })

        binding.nextButton.setOnClickListener{
            navigator().addData(0, test)
            //viewModel.owner1 = test
            //navigator().printAnswers()
            navigator().goToFragmentQuizTwo()
        }
/*//Рабочий кусок для непускания перехода на следующую страницу
        binding.nextButton.setOnClickListener{
            var id: Int = binding.radioGroup.checkedRadioButtonId
            if (id != -1) {
                navigator().goToFragmentQuizTwo()
            } else {
                Toast.makeText(context, "Вариант ответа не выбран", Toast.LENGTH_SHORT).show()
            }
        }*/


        binding.root
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(question: String, answer1: String, answer2: String, answer3: String, answer4: String, answer5: String): FragmentQuizOne {
            val args = Bundle().apply {
                putString(ARG_QUESTION_VALUE, question)
                putString(ARG_ANSWER1_VALUE, answer1)
                putString(ARG_ANSWER2_VALUE, answer2)
                putString(ARG_ANSWER3_VALUE, answer3)
                putString(ARG_ANSWER4_VALUE, answer4)
                putString(ARG_ANSWER5_VALUE, answer5)
            }
            val fragment = FragmentQuizOne()
            fragment.arguments = args
            return fragment
        }

        const val ARG_QUESTION_VALUE = "Any_Question"
        private const val ARG_ANSWER1_VALUE = "answer1"
        private const val ARG_ANSWER2_VALUE = "answer2"
        private const val ARG_ANSWER3_VALUE = "answer3"
        private const val ARG_ANSWER4_VALUE = "answer4"
        private const val ARG_ANSWER5_VALUE = "answer5"
    }

}