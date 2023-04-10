package com.android.leaningviewmodel

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider

//nessa activity, criar um edittext e textview onde
// se passa a mesma mensagem digitada
// em ambos por meio da viewmodel
// através do mutablelivedata



class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var textView: TextView
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        textView = findViewById(R.id.textView2)
        editText = findViewById(R.id.textView)

        editText.addTextChangedListener {
            mainViewModel.digiteAqui.value = it.toString()
        }

        mainViewModel.digiteAqui.observe(this) {
            textView.text = it
        }
    }
}