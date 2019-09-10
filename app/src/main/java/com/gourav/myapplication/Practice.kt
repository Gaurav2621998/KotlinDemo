package com.gourav.myapplication

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Pair
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class Practice : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity1)

        val intent= Intent(this,Activity2::class.java)

        val imageView = findViewById<View>(R.id.imageView) as ImageView
        val textView:TextView=findViewById(R.id.textView2)

        val pairs = arrayOfNulls<Pair<View, String>>(2)

        pairs[0] = Pair(imageView, "imageview")
        pairs[1]=Pair(textView,"textview")



        val options = ActivityOptions.makeSceneTransitionAnimation(this, *pairs)

        startActivity(intent,options.toBundle())


    }


}

