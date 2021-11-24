package arjun.mca.learnaspnet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class BasicTutorial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_tutorial)

        var list = arrayOf("Itroduction", "Life Cycle", "Button", "ASP.NET Web Forms Button", "ASP.NET - Web Pages")
        var adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, list)

        var listview = findViewById<ListView>(R.id.basic_listview)
        listview.adapter = adapter

        listview.setOnItemClickListener { adapterView, view, i, l ->
           when (i) {
               0 -> {
                   var intent = Intent(this, Basic_b1::class.java)
                   intent.putExtra("id", i.toString())
                   startActivity(intent)
               }
               1 -> {
                   var intent = Intent(this, Basic_b1::class.java)
                   intent.putExtra("id", i.toString())
                   startActivity(intent)
               }

               2 -> {
                   var intent = Intent(this, Basic_b1::class.java)
                   intent.putExtra("id", i.toString())
                   startActivity(intent)
               }

               3 -> {
                   var intent = Intent(this, Basic_b1::class.java)
                   intent.putExtra("id", i.toString())
                   startActivity(intent)
               }

               4 -> {
                   var intent = Intent(this, Basic_b1::class.java)
                   intent.putExtra("id", i.toString())
                   startActivity(intent)
               }

               else -> {
                   print("x is neither 1 nor 2")
               }
           }
        }
    }
}
