package arjun.mca.learnaspnet

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(Context: Context):SQLiteOpenHelper(Context,"AspNote",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERDATA(_id INTEGER PRIMARY KEY AUTOINCREMENT,TITLE TEXT,NOTE TEXT)")

        db?.execSQL("CREATE TABLE USERSDB(_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,UNAME TEXT, PASSWORD TEXT,ADMIN TEXT)")
        db?.execSQL("INSERT INTO USERSDB (NAME, UNAME, PASSWORD,ADMIN) VALUES('PARTH','PP','PP','YES')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}


