package com.rsschool.quiz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.rsschool.quiz.contract.BackActionListener
import com.rsschool.quiz.contract.navigator
import com.rsschool.quiz.databinding.FragmentResultBinding


class FragmentQuizResult : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private var listener: BackActionListener? = null

    /*override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as BackActionListener
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                listener?.backNot()
            }
        })
    }*/

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
        fun newInstance(/*st : String*/): FragmentQuizResult {
           /* val args = Bundle().apply {
                putString(ARG_VALUE, st)
            }*/
            val fragment = FragmentQuizResult()
            //fragment.arguments = args
            return fragment
        }

        private const val ARG_VALUE = "ANY"
    }

    /*override fun backNot() {
        Toast.makeText(context, "Чтобы перезапустить квиз нажмите кнопку RESTART", Toast.LENGTH_SHORT).show()
    }*/

    interface BackActionListener {
        fun backNot()
    }
}

