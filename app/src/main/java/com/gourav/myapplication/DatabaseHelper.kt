package com.gourav.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Parcel
import android.os.Parcelable

val DBNAME="My_DB"
val TABLENAME="BOOKDETAIL"
val COL_NAME="Name"
val COL_Price="Price"
val id="ID"

class DatabaseHelper(val context: Context) :SQLiteOpenHelper(context, DBNAME,null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createtable="Create table "+ TABLENAME+" {"+id+" Interger Primary key AutoIncrement,"+
                COL_NAME+" varchar(20),"+ COL_Price+" Integer ";
        db?.execSQL(createtable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertdata(book:Books){
        val db=this.writableDatabase
        var cv=ContentValues()
        cv.put(COL_NAME,book.title)
        cv.put(COL_Price,book.price)
        var result=db.insert(TABLENAME,null,cv)

        if(result==-1.toLong())
        {
            context.showToast("Fail")
        }
        else
        {
            context.showToast("Success")
        }
    }


}