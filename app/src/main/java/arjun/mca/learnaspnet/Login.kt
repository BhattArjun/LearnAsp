package arjun.mca.learnaspnet

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        var btn_login = findViewById<Button>(R.id.btn_login)
        var btn_signup = findViewById<Button>(R.id.btn_signup)


        btn_signup.setOnClickListener {
            startActivity(Intent(this, Signup::class.java))
        }
        btn_login.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))

        }


    }
}
