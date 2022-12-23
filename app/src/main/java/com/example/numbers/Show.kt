package com.example.numbers

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.transition.Explode
import kotlinx.android.synthetic.main.p1.*
import kotlinx.android.synthetic.main.show.*
import tyrantgit.explosionfield.ExplosionField

@Suppress("DEPRECATION")
class Show : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show)
        var exp=ExplosionField.attach2Window(this)
        Safe.text=glist.safe.toString()
        tol.text=glist.tl.toString()
        guessb.setOnClickListener {
            if (guess.text.toString().trim().isNotEmpty()){
                if (guess.text.toString().trim { it <= ' ' }.isNotEmpty()
                ){

                }
                var g=guess.text.toString().toInt()
                glist.tl.remove(g)
                tol.text=glist.tl.toString()
                var mp=MediaPlayer.create(this,R.raw.wrong)
                var mp2=MediaPlayer.create(this,R.raw.snap)
                var mp3=MediaPlayer.create(this,R.raw.carexploded)
                if (glist.gv.containsValue(g)){
                    for ((key,value) in glist.gv){
                        if (g==value){
                            glist.safe.add(key)
                            if(glist.nup==glist.safe.size){
                                mp3.start()
                                exp.explode(textView6)
                                exp.explode(tol)
                                exp.explode(guess)
                                exp.explode(guessb)
                                exp.explode(Safe)
                                Handler(Looper.getMainLooper()).postDelayed({
                                    val intent=Intent(this,Last::class.java)
                                    startActivity(intent)
                                    finish()
                                },1000)
                            }
                            else{
                                mp2.start()
                                exp.explode(tol)
                                Handler(Looper.getMainLooper()).postDelayed({
                                    val intent=Intent(this,Show::class.java)
                                    startActivity(intent)
                                    finish()
                                },1000)

                            }
                        }
                    }
                }
                else{
                    guess.text=null
                    mp.start()
                    tol.animate().apply {
                        duration=1000
                        rotationBy(360f)
                    }
                }
            }
        }

    }

}