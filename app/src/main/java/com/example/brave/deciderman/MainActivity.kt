package com.example.brave.deciderman
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.widget.Toast
import kotlin.concurrent.schedule


fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}
class MainActivity : AppCompatActivity() {

    private val foodList = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        decide_button.setOnClickListener{
            //Toast.makeText(applicationContext, "Wait, Decider Man is deciding!", Toast.LENGTH_SHORT).show()
            try {
                Thread.sleep(1000)

            } catch (e: Exception) {
                e.printStackTrace()
            }
            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            Toast.makeText(applicationContext, "Thanks, Decider Man has decided!", Toast.LENGTH_SHORT).show()
            food_text.text = foodList[randomFood]
        }
        add_button.setOnClickListener{
            val newFood = inputFood_text.text.toString()
            foodList.add(newFood)
            inputFood_text.text.clear()
            Toast.makeText(applicationContext, "You added a choice!", Toast.LENGTH_SHORT).show()
            add_button.hideKeyboard()
        }
        }
        add
    }

