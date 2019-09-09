package com.gourav.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_activity.*

class FragmentActivity:AppCompatActivity(){

    val manager=supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity)

        change.setOnClickListener({
            showfragment()
        })
    }

    private fun showfragment() {

        val transaction=manager.beginTransaction()
        val fragemt=FragmentOne()
        transaction.replace(R.id.fragmentholder,fragemt)
        transaction.addToBackStack(null)
        transaction.commit()


    }

}
