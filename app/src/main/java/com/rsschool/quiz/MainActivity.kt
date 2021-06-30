package com.rsschool.quiz

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.rsschool.quiz.contract.Navigator
import com.rsschool.quiz.contract.navigator
import com.rsschool.quiz.databinding.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), Navigator {
    private lateinit var binding: ActivityMainBinding
    private var answersArray : Array <String> = arrayOf("","","","","","")
    private val trueAnswersArray : Array <String> = arrayOf("33","Колизей","Братислава","В 33 года","От 3 до 6 литров","жаль как пчела",)
    private val quizOneArray : Array <String> = arrayOf("Сколько букв в русском алфавите?","5", "24", "26", "32", "33")
    private val quizTwoArray : Array <String> = arrayOf("Какое название у самого большого амфитеатра Древнего Рима? ","Лувр", "Колизей", "Капуя", "Поццуоли", "Моцарелла")
    private val quizThreeArray : Array <String> = arrayOf("Столица Словакии?","Братислава", "Любляна", "Белград", "Вена", "Артерия")
    private val quizFourArray : Array <String> = arrayOf("В каком возрасте был распят Иисус Христос?","Ни в каком, ведь его не существовало", "В 13 лет", "В 21 год", "В 33 года", "В 66 лет")
    private val quizFiveArray : Array <String> = arrayOf("Сколько литров крови у взрослого человека?","От 1 до 4 литров", "От 3 до 6 литров", "От 7 до 10 литров", "8 литров", "Смотря сколько выпьет перед этим")
    private val quizSixArray : Array <String> = arrayOf("Продолжите фразу: пархай как бабочка, ..","жаль как твоя мать", "жаль как оса", "жаль как пчела", "жаль, что ты приёмный", "Такой фразы не существует")
    private var result = ""
    private var report = ""
    private var counter = 0
    private var fragmentCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if (savedInstanceState == null) {
            val fragment =
                FragmentQuizOne.newInstance(quizOneArray[0],quizOneArray[1], quizOneArray[2], quizOneArray[3], quizOneArray[4], quizOneArray[5])
            supportFragmentManager.beginTransaction().add(R.id.flFragment, fragment).commit()
        }

    }

    private fun launchFragment (fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.flFragment, fragment)
            .commit()
    }

    private fun composeEmail(emailTheme:String, emailText : String){
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_SUBJECT, emailTheme)
            putExtra(Intent.EXTRA_TEXT, emailText)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) goBack()
        return true
    }

    override fun goToFragmentQuizTwo() {
        launchFragment(FragmentQuizTwo.newInstance(quizTwoArray[0],quizTwoArray[1], quizTwoArray[2], quizTwoArray[3], quizTwoArray[4], quizTwoArray[5]))
    }

    override fun goToFragmentQuizThree() {
        launchFragment(FragmentQuizThree.newInstance(quizThreeArray[0],quizThreeArray[1], quizThreeArray[2], quizThreeArray[3], quizThreeArray[4], quizThreeArray[5]))
    }

    override fun goToFragmentQuizFour() {
        launchFragment(FragmentQuizFour.newInstance(quizFourArray[0],quizFourArray[1], quizFourArray[2], quizFourArray[3], quizFourArray[4], quizFourArray[5]))
    }

    override fun goToFragmentQuizFive() {
        launchFragment(FragmentQuizFive.newInstance(quizFiveArray[0],quizFiveArray[1], quizFiveArray[2], quizFiveArray[3], quizFiveArray[4], quizFiveArray[5]))
    }

    override fun goToFragmentQuizSix() {
        launchFragment(FragmentQuizSix.newInstance(quizSixArray[0],quizSixArray[1], quizSixArray[2], quizSixArray[3], quizSixArray[4], quizSixArray[5]))
    }

    override fun goToFragmentResult() {
        launchFragment(FragmentQuizResult.newInstance())
    }

    override fun createEmailReport():String {
        report = "Ваш результат составляет $counter из ${answersArray.size} \n"  +
                "\n" +
                "${quizOneArray[0]} \n" +
                "Правильный ответ: ${trueAnswersArray[0]} \n" +
                "Ваш ответ: ${answersArray[0]} \n" +
                "__________________________\n" +
                "${quizTwoArray[0]} \n" +
                "Правильный ответ: ${trueAnswersArray[1]} \n" +
                "Ваш ответ: ${answersArray[1]} \n" +
                "__________________________\n" +
                "${quizThreeArray[0]} \n" +
                "Правильный ответ: ${trueAnswersArray[2]} \n" +
                "Ваш ответ: ${answersArray[2]} \n" +
                "__________________________\n" +
                "${quizFourArray[0]} \n" +
                "Правильный ответ: ${trueAnswersArray[3]} \n" +
                "Ваш ответ: ${answersArray[3]} \n" +
                "__________________________\n" +
                "${quizFiveArray[0]} \n" +
                "Правильный ответ: ${trueAnswersArray[4]} \n" +
                "Ваш ответ: ${answersArray[4]} \n" +
                "__________________________\n" +
                "${quizSixArray[0]} \n" +
                "Правильный ответ: ${trueAnswersArray[5]} \n" +
                "Ваш ответ: ${answersArray[5]} \n"
        return report
    }

    override fun printResaltOfQuiz() :String {
        for (i in answersArray.indices){
            for (k in trueAnswersArray.indices) if (answersArray[i] == trueAnswersArray[k]) counter ++
        }
        result = "Ваш результат: $counter из ${answersArray.size}"
        return result
    }

    override fun addData(num : Int, str: String) {
        answersArray[num] = str
    }

    override fun shareToEmail() {
        composeEmail("Результаты квиза", createEmailReport())
    }

    override fun goBack() {
        onBackPressed()
    }

    override fun goToMenu() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun finish() {
        exitProcess(-1)
    }

    override fun resetCounters() {
        result = ""
        report = ""
        counter = 0
    }

    override fun onBackPressed() {
        fragmentCount = supportFragmentManager.backStackEntryCount
        if (fragmentCount == 5) supportFragmentManager.popBackStack() else super.onBackPressed()
    }
}

