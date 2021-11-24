package arjun.mca.learnaspnet

import android.content.ContentValues
import android.content.Intent
import android.content.pm.ApplicationInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        var edname = findViewById<EditText>(R.id.edname)
        var eduname = findViewById<EditText>(R.id.eduname)
        var edpass = findViewById<EditText>(R.id.edpass)
        var edcpass = findViewById<EditText>(R.id.edcpass)
        var submit = findViewById<Button>(R.id.btn_submit)

        var helper = MyDBHelper(applicationContext)
        var db = helper.writableDatabase


        var from = arrayOf("NAME","UNAME","PASSWORD")
        var adapter = ArrayAdapter(applicationContext, android.R.layout.simple_dropdown_item_1line, from)

        submit.setOnClickListener {
            var cv = ContentValues()
        if(edpass.text.toString().equals(edcpass.text.toString()) && edname.text.toString().isNotBlank() && eduname.text.toString().isNotBlank() &&edpass.text.toString().isNotBlank()) {
                cv.put("PASSWORD", edpass.text.toString())
                cv.put("NAME", edname.text.toString())
                cv.put("UNAME", eduname.text.toString())
                db.insert("USERSDB", null, cv)
                Toast.makeText(applicationContext, "Your Recoed is Added..!", Toast.LENGTH_LONG).show()

                edname.setText("")
                eduname.setText("")
                edpass.setText("")
                edcpass.setText("")

                edname.requestFocus()
            }
            else {
                Toast.makeText(applicationContext,"Enter Valid Vlues..!!",Toast.LENGTH_LONG).show()
            }
        }
            //db.rawQuery("SELECT _id,TITLE, NOTE FROM USERDATA",null)
            //db.rawQuery("SELECT _id,TITLE, NOTE FROM USERDATA",null)

        }

    }
