package com.example.simplecalc2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var input: String = ""
        var isOperationWasClicked: Boolean = false
        val firstNumberView: TextView = findViewById(R.id.FirstNumberView)
        val operationView: TextView = findViewById(R.id.OperationView)
        val answerView: TextView = findViewById(R.id.AnswerFieldView)

        fun Calculate(newOperation: String) {
            if (answerView.text.isBlank()) {
                answerView.error = "Введите число"
            } else {
                if (!isOperationWasClicked) {
                    isOperationWasClicked = true
                    firstNumberView.text = answerView.text.toString()
                    operationView.text = newOperation
                    input = ""
                    answerView.text = ""
                } else {
                    val Number1 = firstNumberView.text.toString().toDouble()
                    val Number2 = answerView.text.toString().toDouble()

                    firstNumberView.text =
                        when (operationView.text) {
                            "*" -> (Number1 * Number2).toString()
                            "/" -> if (Number2 == 0.0) "a" else (Number1 / Number2).toString()
                            "+" -> (Number1 + Number2).toString()
                            "-" -> (Number1 - Number2).toString()
                            else -> {
                                "Error"
                            }
                        }
                    try {
                        firstNumberView.text.toString().toDouble()
                        answerView.error = null
                        answerView.text = ""

                        operationView.text = newOperation

                        input = ""
                    } catch (nfe: NumberFormatException) {
                        answerView.error = "Ошибка деления на 0"
                        firstNumberView.text = ""
                        operationView.text = ""
                        operationView.text = ""
                        answerView.text = ""
                        input = ""
                        isOperationWasClicked = false
                    }
                }
            }
        }

        fun addToInput(Symbol: Char) {
            input += Symbol
            answerView.text = input
        }
        val btn1: Button = findViewById(R.id.button)
        btn1.setOnClickListener { addToInput('0') }

        val btn2: Button = findViewById(R.id.button2)
        btn2.setOnClickListener { addToInput('1') }

        val btn3: Button = findViewById(R.id.button3)
        btn3.setOnClickListener { addToInput('2') }

        val btn4: Button = findViewById(R.id.button4)
        btn4.setOnClickListener { addToInput('3') }

        val btn5: Button = findViewById(R.id.button5)
        btn5.setOnClickListener { addToInput('4') }

        val btn6: Button = findViewById(R.id.button6)
        btn6.setOnClickListener { addToInput('5') }

        val btn7: Button = findViewById(R.id.button7)
        btn7.setOnClickListener { addToInput('6') }

        val btn8: Button = findViewById(R.id.button8)
        btn8.setOnClickListener { addToInput('7') }

        val btn9: Button = findViewById(R.id.button9)
        btn9.setOnClickListener { addToInput('8') }

        val btn10: Button = findViewById(R.id.button10)
        btn10.setOnClickListener { addToInput('9') }
        val dot: Button = findViewById(R.id.dot)
        dot.setOnClickListener {
            if (!input.contains('.')) {
                addToInput('.')
            }
        }

        val neg: Button = findViewById(R.id.buttonNeg)
        neg.setOnClickListener {
            if (!input.contains('-')) {
                addToInput('-')
            }
        }
        val del: Button = findViewById(R.id.Del)
        del.setOnClickListener {
            input = input.dropLast(1)
            answerView.text = input
        }

        val clr: Button = findViewById(R.id.clr)
        clr.setOnClickListener {
            firstNumberView.text = ""
            operationView.text = ""
            answerView.text = ""
            input = ""
            isOperationWasClicked = false
            answerView.error = null
        }

        val btnMult: Button = findViewById(R.id.btnOpMultiply)
        btnMult.setOnClickListener { Calculate("*") }
        val btnMin: Button = findViewById(R.id.btnOpMinus)
        btnMin.setOnClickListener { Calculate("-") }
        val btnDiv: Button = findViewById(R.id.btnOpDivide)
        btnDiv.setOnClickListener { Calculate("/") }

        val btnPlus: Button = findViewById(R.id.btnOpPlus)
        btnPlus.setOnClickListener { Calculate("+") }

        val btnEq: Button = findViewById(R.id.btnEquals)
        btnEq.setOnClickListener {
            if (answerView.text.isBlank()) {
                answerView.error = "Введите число"
            } else if (operationView.text.isBlank()) {
                answerView.error = "Введите операцию"
            } else {
                val Number1 = firstNumberView.text.toString().toDouble()
                val Number2 = answerView.text.toString().toDouble()
                if (isOperationWasClicked) {
                    answerView.text =
                        when (operationView.text) {
                            "*" -> (Number1 * Number2).toString()
                            "/" -> if (Number2 == 0.0) "a" else (Number1 / Number2).toString()
                            "+" -> (Number1 + Number2).toString()
                            "-" -> (Number1 - Number2).toString()
                            else -> {
                                "Error"
                            }
                        }
                    try {
                        answerView.text.toString().toDouble()
                        answerView.error = null
                    } catch (nfe: NumberFormatException) {
                        answerView.error = "Ошибка деления на 0"
                        answerView.text = ""
                    }
                    firstNumberView.text = ""
                    operationView.text = ""
                    input = ""
                    isOperationWasClicked = false
                }
            }
        }
    }
}
