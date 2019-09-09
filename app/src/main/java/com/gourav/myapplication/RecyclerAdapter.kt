package com.gourav.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.card.view.*

class RecyclerAdapter(val context:Context,var books:List<Books>): RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.card,p0,false)
        return MyViewHolder(view)

    }



    override fun getItemCount(): Int {
       return books.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        var book=books[p1]
        p0.setdata(book,p1)
    }

    inner class MyViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){

        var currentbook:Books?=null
        var currentpos:Int=0
        init {
            itemview.setOnClickListener {
                currentbook?.let {
                    context.showToast(currentbook!!.title+"Clicked",Toast.LENGTH_LONG)
                }

            }
        }

        fun setdata(books: Books,p1:Int)
        {
            books?.let {
                itemView.textView.text=books.title
                this.currentbook=books
                this.currentpos=p1
            }

        }
    }
}