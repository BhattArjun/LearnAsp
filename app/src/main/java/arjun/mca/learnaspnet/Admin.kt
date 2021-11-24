package arjun.mca.learnaspnet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleCursorAdapter

class Admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        var helper = MyDBHelper(applicationContext)
        var db  = helper.readableDatabase

        var from = arrayOf("NAME","UNAME","PASSWORD")
        var rs = db.rawQuery("SELECT * FROM USERSDB",null)


        var adapter1 = SimpleCursorAdapter(applicationContext,
            //android.R.layout.simple_list_item_2,
            R.layout.mylayout,
            rs,arrayOf("NAME","UNAME","PASSWORD"),
            //intArrayOf(android.R.id.text1,android.R.id.text2),
            intArrayOf(R.id.t1,R.id.t2,R.id.t3),
            0)


        var  lv = findViewById<ListView>(R.id.admin_lv)
        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_dropdown_item_1line,from)
        adapter.notifyDataSetChanged()
        lv.adapter = adapter1



    }
}