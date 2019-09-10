package com.gourav.myapplication

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity1.*

class Activityone:AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity1)

        card.setOnClickListener {
            var intent=Intent(this,Activity2::class.java)

            val pairs = arrayOfNulls<android.util.Pair<View, String>>(3)


//            pairs[0]= Pair(imageView,"imageview")
//            pairs[1]=Pair(textView2,"textview")

            val options = ActivityOptions.makeSceneTransitionAnimation(this, *pairs)




            startActivity(intent)
        }
    }
}