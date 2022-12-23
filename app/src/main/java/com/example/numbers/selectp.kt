package com.example.numbers

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.selectp.*


class selectp:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selectp)
        val players = listOf(2,3,4,5,6,7,8)
        val adapter=ArrayAdapter(this,R.layout.dropdown_item,players)
        autoCompleteTextView .setAdapter(adapter)
        button.setOnClickListener {
            val nplayers=autoCompleteTextView.text.toString().toInt()
            glist.nup=nplayers-1
            Intent(this,P1::class.java).also {
                it.putExtra("np",nplayers)
                startActivity(it)
                finish()
            }

        }
    }
}