package com.rsschool.quiz

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.widget.RadioGroup
import android.widget.Toast
import com.rsschool.quiz.contract.navigator
import com.rsschool.quiz.databinding.FragmentResultBinding


class FragmentQuizResult : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        var str = navigator().printAnswers()

        binding.restartButton.setOnClickListener { navigator().goToMenu() }
        binding.exitButton.setOnClickListener { navigator().finish() }

        binding.sendEmailBtn.setOnClickListener {Toast.makeText(context, "Извините, отправка резултата на email, как и подсчёт ответов, пока не работают",Toast.LENGTH_SHORT).show()
        }

        //binding.shareButton.setOnClickListener { Toast.makeText(context, "${navigator().printAnswers()}", Toast.LENGTH_SHORT).show() }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(st : String): FragmentQuizResult {
            val args = Bundle().apply {
                putString(ARG_VALUE, st)
            }
            val fragment = FragmentQuizResult()
            //args.putInt(PREVIOUS_RESULT_KEY, previousResult)
            fragment.arguments = args
            return fragment
        }

        private const val ARG_VALUE = "ANY"
    }



}

