package edu.towson.cosc431.christian.hangman

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class FiveLetter(context: Context): SQLiteOpenHelper(context, dbname, factory, version) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table words (id integer primary key autoincrement,"+
                "w varchar(5)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData( word:String){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("w",word)


        db.insert("words",null,values)
        db.close()
    }


    companion object {
        internal val dbname = "wordsDB"
        internal val factory = null
        internal val version = 1
    }

}