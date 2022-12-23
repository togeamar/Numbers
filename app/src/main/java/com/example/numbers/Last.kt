package com.example.numbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Process.myPid
import kotlinx.android.synthetic.main.last.*

class Last : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.last)
        lastt.text=glist.safe.toString()+"SAFE"
        for((k,v) in glist.gv){
            if (k !in glist.safe){
                lasttt.text="["+k+"]"
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        android.os.Process.killProcess(myPid())
    }
}