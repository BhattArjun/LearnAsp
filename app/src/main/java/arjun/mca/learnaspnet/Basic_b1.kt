package arjun.mca.learnaspnet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Basic_b1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_b1)

        var tv = findViewById<TextView>(R.id.Basic_tv1)
        var img = findViewById<ImageView>(R.id.allimg)

        val id = intent.getStringExtra("id")?.toInt()
        tv.setText(R.string.intro1).toString()


       when(id)
        {
            0 -> {tv.setText(R.string.intro1).toString(); img.setBackgroundResource(R.drawable.ad_1);}
            1 -> {tv.setText(R.string.intro2).toString(); img.setBackgroundResource(R.drawable.ad_2);}
            2 -> {tv.setText(R.string.intro3).toString(); img.setBackgroundResource(R.drawable.ad_3);}
            3 -> {tv.setText(R.string.intro4).toString(); img.setBackgroundResource(R.drawable.ad_4);}
            4 -> {tv.setText(R.string.intro5).toString(); img.setBackgroundResource(R.drawable.ad_5);}

        }

    }
}