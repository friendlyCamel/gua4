package com.example.gua4_v1_0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setTheme(R.style.)
        setContentView(R.layout.activity_main)
        var a =AnimationUtils.loadAnimation(this,R.anim.start)
        val image: ImageView = findViewById(R.id.imageView2)
        image.startAnimation(a)
    }
    fun sig(view:View){
        val intent = Intent(this,sig_activity::class.java)
        startActivity(intent)
    }
    fun sign(view:View){
        val intent = Intent(this,homepage::class.java)
        startActivity(intent)
    }


}