package com.example.lab4

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    private lateinit var inputPlainText: EditText
    private lateinit var outputTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputPlainText = findViewById(R.id.plain_text);
        outputTextView = findViewById(R.id.text_view);
        outputTextView.movementMethod = ScrollingMovementMethod()
    }

    fun read(view: View?) {
        openFileInput("test.txt").use { fileInputStream ->
            val reader = InputStreamReader(fileInputStream)
            val buffer = BufferedReader(reader)
            outputTextView.text = buffer.readText()
        }
    }

    fun write(view: View?): Unit {
        val file = openFileOutput("test.txt", MODE_PRIVATE)
        file.write(inputPlainText.text.toString().toByteArray())
        // Записать данные в файл с режимом приватного доступа к данным
        // приложением-владельцем, используя функцию openFileOutput("a.txt", MODE_PRIVATE)
    }
}
