package com.example.numbers3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button) //угадать
        val number = findViewById<EditText>(R.id.editTextNumber) //ввод числа
        val text = findViewById<TextView>(R.id.textView2) //сообщения
        val button = findViewById<Button>(R.id.button2) // начать сначала
        var count = 0

        var random = Random.nextInt(1, 10)
        text.text =
            "Загадано число в диапазоне от 1 до 9. Попробуйте его угадать. У вас есть 3 попытки!"

        btn.setOnClickListener {
            if (random < 0) {
                random = Random.nextInt(0, 10)
            }
            var userInput = number.text.toString()
            if (userInput.isBlank()) {
                text.text = "Введите число!"
            } else {
                var num = userInput.toInt()
                if (num < 10 && num > 0) {
                    if (count < 2) {
                        if (num == random) {
                            text.text = "Вы победили!!! Сыграете ещё раз?"
                            btn.isClickable = false
                            count = 0
                            num = -1
                            random = -1
                        } else {
                            text.text = if (num > random) "меньше!" else "больше!"
                            count++
                        }
                    } else {
                        text.text = if (num == random) "Вы победили!!! Сыграете ещё раз?" else "К сожалению, вы поиграли. Попробуйте ещё раз!"
                        btn.isClickable = false
                        count = 0
                        num = -1
                        random = -1
                    }
                } else {
                    text.text = "Введите число из диапазона от 1 до 9!"
                }
            }

            button.setOnClickListener {
                btn.isClickable = true
                var random = Random.nextInt(1, 10)
                text.text = "Загадано число в диапазоне от 1 до 9. Попробуйте его угадать. У вас есть 3 попытки"
            }
        }
    }
}