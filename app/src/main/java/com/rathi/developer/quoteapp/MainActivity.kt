package com.rathi.developer.quoteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TestLooperManager
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    private val quoteText: TextView
      get() = findViewById(R.id.quoteText)

    private val authorText: TextView
      get() = findViewById(R.id.quoteAuthor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(application)).get(MainViewModel::class.java)
        setQuote(mainViewModel.getQuotes())
    }

    fun setQuote(quotes: Quotes){
        quoteText.text = quotes.text
        authorText.text = quotes.author
    }

    fun onPrevious(view: View) {
        setQuote(mainViewModel.prevQuotes())
    }
    fun onNext(view: View) {
        setQuote(mainViewModel.nextQuotes())

    }
    fun onShare(view: View) {}
}