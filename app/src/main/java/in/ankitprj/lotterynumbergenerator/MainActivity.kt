package `in`.ankitprj.lotterynumbergenerator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    
    lateinit var  editTextName: EditText
    lateinit var  generatebtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        editTextName = findViewById(R.id.editTextName)
        generatebtn = findViewById(R.id.generateBtn)
        
        generatebtn.setOnClickListener { 
            val name:String = editTextName.text.toString()

            // Explicit Intent
            val i = Intent(this,SecondActivity::class.java)
            i.putExtra("username",name)
            startActivity(i)
        }

    }
}