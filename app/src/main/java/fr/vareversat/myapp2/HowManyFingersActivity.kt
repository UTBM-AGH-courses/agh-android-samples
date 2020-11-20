package fr.vareversat.myapp2

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_how_many_fingers.*

class HowManyFingersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_many_fingers)
    }

    fun play(view: View) {
        val myEditText = findViewById<EditText>(R.id.edit_text_number)
        val imageView1 = findViewById<ImageView>(R.id.image1)
        val imageView2 = findViewById<ImageView>(R.id.image2)
        val resultText = findViewById<TextView>(R.id.result)
        val text = Integer.parseInt(myEditText.text.toString())
        var random = (1..12).random()
        if (text == random) {
            resultText.text = "Yeah! You win! I'm showing " + random.toString()
            resultText.setTextColor(Color.GREEN)
        } else {
            resultText.text = "No! You lost! I'm showing " + random.toString()
            resultText.setTextColor(Color.RED)
        }

        val image1ID = when (random) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            6 -> R.drawable.dice6
            7 -> R.drawable.dice6
            8 -> R.drawable.dice6
            9 -> R.drawable.dice6
            10 -> R.drawable.dice6
            11 -> R.drawable.dice6
            12 -> R.drawable.dice6
            else -> 0
        }

        val image2ID = when (random) {
            7 -> R.drawable.dice1
            8 -> R.drawable.dice2
            9 -> R.drawable.dice3
            10 -> R.drawable.dice4
            11 -> R.drawable.dice5
            12 -> R.drawable.dice6
            else -> 0
        }

        imageView1.setImageResource(image1ID)
        imageView2.setImageResource(image2ID)


    }

}
