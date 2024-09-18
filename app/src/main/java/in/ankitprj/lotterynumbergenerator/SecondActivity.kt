package `in`.ankitprj.lotterynumbergenerator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {

    lateinit var  shareBtn:Button
    lateinit var textViewresult:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        shareBtn = findViewById(R.id.shareBtn)
        textViewresult = findViewById(R.id.textViewresult)




        // Generate 6 random numbers and store them in a string
        val myRandomValues = List(6) { Random.nextInt(1, 99) }
        textViewresult.setText(myRandomValues.toString())

        // Getting the Username from  the main Activity
        var username = receiveUserName()

        // Sharing the username & generated Numbers with Email App
        shareBtn.setOnClickListener {
            shareresult(username,myRandomValues.toString())
        }






    }





    fun  receiveUserName():String{
        // retrieve the extras that were added to an Intent
        // ?--> indicates that the variable can be NULL
        var bundle:Bundle?= intent.extras

        // Give me the key, I`ll give you the value
        var username = bundle?.getString("username").toString()

        return  username
    }

    fun shareresult(username:String,generatedNums:String){

        // Implicit Intents: specify an action to be performed
        // and the system determines the appropriate component
        // to handle that action based on the available registered
        // component and their declared capabilities

        // Sending data to another application
        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT,"$username generates these numbers")
        i.putExtra(Intent.EXTRA_TEXT,"The Lottery Numbers are: $generatedNums")
        startActivity(i)
    }
}