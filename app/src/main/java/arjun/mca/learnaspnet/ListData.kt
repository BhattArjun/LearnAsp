package arjun.mca.learnaspnet

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ListData : AppCompatActivity() {

    lateinit var tv1 :TextView
    lateinit var tv2 :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_data)


        var helper = MyDBHelper(applicationContext)
        var db  = helper.readableDatabase

        var note = intent.getStringExtra("note")

        var rs = db.rawQuery("SELECT * FROM USERDATA WHERE _id = ?", arrayOf(note.toString()))

        var name = findViewById<EditText>(R.id.note_name)
        var data = findViewById<EditText>(R.id.note_data)


        rs.moveToFirst()
        name.setText(rs.getString(1)).toString()
        data.setText(rs.getString(2)).toString()


            var btn = findViewById<ImageButton>(R.id.edt_btn)
            btn.setOnClickListener {
                var cv = ContentValues()
                cv.put("TITLE",name.text.toString())
                cv.put("NOTE",data.text.toString())
                db.update("USERDATA",cv,"_id = ?", arrayOf(name.text.toString()))
                rs.requery()

            }


    }
}