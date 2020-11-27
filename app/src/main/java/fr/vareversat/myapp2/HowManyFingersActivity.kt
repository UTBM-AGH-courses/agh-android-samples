package fr.vareversat.myapp2

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_how_many_fingers.*

class HowManyFingersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_many_fingers)
    }

    private fun showDices(random: Int) {
        val image1ID = when {
            random == 1 -> R.drawable.dice1
            random == 2 -> R.drawable.dice2
            random == 3 -> R.drawable.dice3
            random == 4 -> R.drawable.dice4
            random == 5 -> R.drawable.dice5
            random == 6 -> R.drawable.dice6
            random >= 7 -> R.drawable.dice6
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

        image1.setImageResource(image1ID)
        image2.setImageResource(image2ID)
    }

    private fun showText(random: Int, input: Int) {
        if (input == random) {
            result.text = "Yeah! You win! I'm showing $random"
            result.setTextColor(Color.GREEN)
        } else {
            result.text = "No! You lost! I'm showing $random"
            result.setTextColor(Color.RED)
        }
    }

    fun play(view: View) {
        // Get the number enter by the player
        val input = Integer.parseInt(edit_text_number.text.toString())
        // Pick a random number
        val random = (1..12).random()

        // Show the correct dices
        showDices(random)
        // Show the correct message
        showText(random, input)
    }

}
