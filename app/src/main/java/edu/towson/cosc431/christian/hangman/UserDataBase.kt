package edu.towson.cosc431.christian.hangman

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDataBase(context: Context): SQLiteOpenHelper(context,dbname, factory, version) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table user (id integer primary key autoincrement,"+
                "name varchar(30), password varchar(20))")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //Todo use an interface for the ones below

    fun insertUserData( name:String,password:String){
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("name",name)
        values.put("password",password)
        //values.put("win", "0")
        //values.put("loss", "0")

        db.insert("user",null, values)
        db.close()
    }

    fun userPresent(name: String, password: String):Boolean{
        val db= readableDatabase
        val query="select * from user where name = '$name' and password = '$password'"
        val cursor=db.rawQuery(query, null)
        if (cursor.count <= 0){
            cursor.close()
            return false
        }
        else{
            track = name
            cursor.close()
            return true
        }
    }

    fun userNamePresent(name: String):Boolean{
        val db= readableDatabase
        val query="select * from user where name = '$name'"
        val cursor=db.rawQuery(query, null)
        if (cursor.count <= 0){
            cursor.close()
            return true
        }
        else{
            cursor.close()
            return false
        }
    }
    fun getName() : ArrayList<Table>{
        val query = "select * from user"
        val db = readableDatabase
        val cursor = db.rawQuery(query,null)
        val users = ArrayList<Table>()

        if(cursor.moveToFirst()){
            if (cursor != null && cursor.count > 0) {
                do {
                    val user = Table()
                    user.username = cursor.getString(cursor.getColumnIndex("name"))
                    user.win = "0"
                    user.loss = "0"
                    //user.win = cursor.getString(cursor.getColumnIndex("win"))
                    //user.loss = cursor.getString(cursor.getColumnIndex("loss"))

                    users.add(user)
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()
        return users

    }

    /*fun updateWin(){

        val db=writableDatabase
        val query="select * from user"
        val cursor=db.rawQuery(query, null)

        if(cursor.moveToFirst()){
            do {
                if (cursor.getString(cursor.getColumnIndex("name")) == track){
                    var wins = cursor.getString(cursor.getColumnIndex("win")).toInt()
                    wins++

                    val cv = ContentValues()
                    cv.put("win", wins.toString())
                    db.update("user", cv, "id =? AND name +?", "d")
                }


            }while (cursor.moveToNext())
        }
        cursor.close()


    }*/

    companion object {
        internal val dbname = "userDB"
        internal val factory = null
        internal val version = 1

        internal var track:String = ""
    }
}