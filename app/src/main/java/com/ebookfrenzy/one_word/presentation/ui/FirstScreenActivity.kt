package com.ebookfrenzy.one_word.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ebookfrenzy.one_word.presentation.MainActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FirstScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.launch {
            delay(3000L)
            val intent = Intent(this@FirstScreenActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}