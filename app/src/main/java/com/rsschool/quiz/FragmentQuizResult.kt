package com.rsschool.quiz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import com.rsschool.quiz.contract.navigator
import com.rsschool.quiz.databinding.FragmentResultBinding


class FragmentQuizResult : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                Toast.makeText(context, "Чтобы начать квиз заново нажмите кнопку RESTART", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        binding.previousResult.text = navigator().printResaltOfQuiz()
        binding.toolbar.navigationIcon = null

        binding.restartButton.setOnClickListener {
            navigator().resetCounters()
            navigator().goToMenu() }
        binding.exitButton.setOnClickListener { navigator().finish() }

        binding.sendEmailBtn.setOnClickListener {
            navigator().shareToEmail()
            //Toast.makeText(context, "Извините, отправка резултата на email пока не работают",Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(): FragmentQuizResult {
            val fragment = FragmentQuizResult()
            return fragment
        }
    }

}





