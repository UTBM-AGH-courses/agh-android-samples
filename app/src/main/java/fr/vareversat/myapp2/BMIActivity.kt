package fr.vareversat.myapp2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bmi.*
import kotlin.math.pow

class BMIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
    }

    fun computeBMI(view: View) {
        // Get the mass
        val mass = (mass_edit_text.text.toString()).toDouble()
        // Get the height
        val height = (height_edit_text.text.toString()).toDouble()

        // Compute the BMI
        val bmi = mass / height.pow(2)

        // Choose the right image according to the BMI
        val imageID = when {
            bmi < 18.5 -> R.drawable.underweight
            bmi >= 18.5 && bmi < 24.9 -> R.drawable.healthy
            bmi >= 25 && bmi < 29.9 -> R.drawable.overweight
            bmi >= 30 -> R.drawable.obesity
            else -> 0
        }
        // Display the image
        image_bmi.setImageResource(imageID)
    }
}