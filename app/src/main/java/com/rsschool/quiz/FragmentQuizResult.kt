package com.rsschool.quiz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.widget.RadioGroup
import com.rsschool.quiz.contract.navigator
import com.rsschool.quiz.databinding.FragmentResultBinding


class FragmentQuizResult : Fragment() {
    /*@Override public onCreateView( inflater: LayoutInflater, container: ViewGroup , savedInstanceState: Bundle ): View  {
    // create ContextThemeWrapper from the original Activity Context with the custom theme
    /val contextThemeWrapper : Context = ContextThemeWrapper(activity, R.style.Theme_Quiz_Second)
    // clone the inflater using the ContextThemeWrapper
    /
        val localInflater
        localInflater :LayoutInflater= inflater.cloneInContext(Theme_Quiz_Second)
    // inflate the layout using the cloned inflater, not default inflater
    /return localInflater.inflate(R.layout.fragment_result, view, false)
    }*/

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        binding.previousResult.text = requireArguments().getString(ARG_QUESTION_VALUE)!!
        binding.previousButton.setOnClickListener { navigator().goBack() }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(question: String): FragmentQuizResult {
            val args = Bundle().apply {
                putString(ARG_QUESTION_VALUE, question)
            }
            val fragment = FragmentQuizResult()
            //args.putInt(PREVIOUS_RESULT_KEY, previousResult)
            fragment.arguments = args
            return fragment
        }

        private const val ARG_QUESTION_VALUE = "Any_Question"
    }

}

