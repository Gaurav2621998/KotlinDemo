package com.gourav.myapplication

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    lateinit var diceimage:ImageView

    var books=ArrayList<Books>()



     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val rollbutton:Button=findViewById(R.id.roll_button)
        rollbutton.setOnClickListener{
            showToast("Hello Gaurav")
            rollDice()

        }
        
        val roll2:Button=findViewById(R.id.roll_button1)
        roll2.setOnClickListener{
            addval(it)
        }
        diceimage=findViewById(R.id.img)

         books.add(Books("Maths"))
         books.add(Books("English"))
         books.add(Books("Hindi"))
         books.add(Books("Science"))

         val layout=LinearLayoutManager(this)
         layout.orientation=LinearLayoutManager.VERTICAL
         recycler.layoutManager=layout

         var adapter=RecyclerAdapter(this,books)
         recycler.adapter=adapter

         val context=this

         val db=DatabaseHelper(context)
         var book=Books("Android")
         db.insertdata(book)



    }

    private fun addval(it: View?) {
        if (it != null) {
            it.visibility=View.GONE
        }
    }

    private fun rollDice() {
        val textview:TextView=findViewById(R.id.textv);
        val i = Random().nextInt(6) + 1

        val dra=when(i){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceimage.setImageResource(dra)



        textview.text= i.toString()


    }
}
