package arjun.mca.learnaspnet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class AspWithMVC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asp_with_mvc)

        var list = arrayOf("Model", "View", "Controller")
        var adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, list)

        var lv = findViewById<ListView>(R.id.asp_listview)
        lv.adapter = adapter

        lv.setOnItemClickListener { parent, view, i, id ->
            when(i)
            {
                  0->{
                      var intent = Intent(this, Basic_b1::class.java)
                      intent.putExtra("id", i.toString())
                      startActivity(intent)
                  }
                  1->{
                      var intent = Intent(this, Basic_b1::class.java)
                      intent.putExtra("id", i.toString())
                      startActivity(intent)
                  }
                  2->{
                      var intent = Intent(this, Basic_b1::class.java)
                      intent.putExtra("id", i.toString())
                      startActivity(intent)
                  }
            }

        }



    }
}