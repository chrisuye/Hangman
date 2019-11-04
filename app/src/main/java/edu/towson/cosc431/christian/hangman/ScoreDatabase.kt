package edu.towson.cosc431.christian.hangman

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ScoreDatabase(context: Context): SQLiteOpenHelper(context, dbname, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("create table score (id integer primary key autoincrement,"+
                "win, loss)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertScoreData( win:Int, loss:Int){
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("win",win)
        values.put("loss",loss)

        db.insert("score",null, values)
        db.close()
    }

    fun getScore() : ArrayList<ScoreTable>{
        val query = "select * from score"
        val db = readableDatabase
        val cursor = db.rawQuery(query,null)
        val scores = ArrayList<ScoreTable>()

        if (cursor.count <= 0){
            //Toast.makeText(mCtx,"No Recored", Toast.LENGTH_SHORT).show()
        }
        else{
            while (cursor.moveToNext()){
                val score = ScoreTable()
                //user.username = cursor.getString(cursor.getColumnIndex("name"))
                score.win = cursor.getInt(cursor.getColumnIndex("win"))
                score.loss = cursor.getInt(cursor.getColumnIndex("loss"))
                scores.add(score)
            }
        }
        cursor.close()
        db.close()
        return scores

    }

    companion object {
        internal val dbname = "scoreDB"
        internal val factory = null
        internal val version = 1
    }
}