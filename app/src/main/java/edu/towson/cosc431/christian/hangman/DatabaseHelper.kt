package edu.towson.cosc431.christian.hangman

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DatabaseHelper(context: Context):SQLiteOpenHelper (context,dbname, factory, version) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table user (id integer primary key autoincrement,"+
                "name varchar(30), password varchar(20))")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertUserData( name:String,password:String){
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("name",name)
        values.put("password",password)

        db.insert("user",null, values)
        db.close()
    }

    fun userPresent(name: String, password: String):Boolean{
        val db=writableDatabase
        val query="select * from user where name = '$name' and password = '$password'"
        val cursor=db.rawQuery(query, null)
        if (cursor.count <= 0){
            cursor.close()
            return false
        }
        else{
            cursor.close()
            return true
        }
    }

    fun userNamePresent(name: String):Boolean{
        val db=writableDatabase
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

        if (cursor.count <= 0){
            //Toast.makeText(mCtx,"No Recored", Toast.LENGTH_SHORT).show()
        }
        else{
            while (cursor.moveToNext()){
                val user = Table()
                user.username = cursor.getString(cursor.getColumnIndex("name"))

                users.add(user)
            }
        }
        cursor.close()
        db.close()
        return users

    }

    companion object {
        internal val dbname = "userDB"
        internal val factory = null
        internal val version = 1
    }

}