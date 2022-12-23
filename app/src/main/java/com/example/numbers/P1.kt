package com.example.numbers

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.p1.*

class P1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.p1)
        btn1.setOnClickListener {
            if (editTextName.text.toString().trim { it <= ' ' }.isNotEmpty()
                && editTextNo1.text.toString().trim { it <= ' ' }.isNotEmpty()
            ){
                var tp=glist.nup+1
                glist.countp=glist.countp+1
                var Name = editTextName.text.toString()
                var No1 = editTextNo1.text.toString().toInt()
                glist.gv.put(Name, No1)
                if (glist.countp<tp) {
                    val intent = Intent(this, P1::class.java)
                    startActivity(intent)
                    finish()
                }
                if(glist.countp==tp){
                    val intent=Intent(this,Show::class.java)
                    startActivity(intent)
                    finish()
                }

            }

        }
    }
}