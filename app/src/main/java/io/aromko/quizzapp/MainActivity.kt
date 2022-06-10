package io.aromko.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quizzapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnStart: Button = findViewById(R.id.btnStart)
        val etName: EditText = findViewById(R.id.etName)

        btnStart.setOnClickListener {
            if (etName.text.isEmpty()) {
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show()
            } else {
                //sagt von welcher Activity (this) eine andere Activity gestartet werden soll
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                //Werte von einer Activity an die andere weitergeben
                intent.putExtra(Constants.USER_NAME, etName.text.toString())
                //ruft die Zielactivity auf
                startActivity(intent)
                //wird nur benötigt, wenn man verhindern möchte zur aufrufenden Activity zurück zu kehren
                finish()
            }
        }
    }
}