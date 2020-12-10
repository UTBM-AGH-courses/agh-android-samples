package fr.vareversat.myapp2

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun writeToLog(view: View) {
        Log.i("Alo", "Alo");
    }

    fun showToastMessage(view: View) {
        val toast = Toast.makeText(this, "The message from the first button", Toast.LENGTH_SHORT)
        val toastLayout = toast.view as LinearLayout
        val toastMessage = toastLayout.getChildAt(0) as TextView

        toast.setGravity(Gravity.TOP, 0, 300)
        toastLayout.setBackgroundColor(Color.RED)
        toastMessage.gravity = Gravity.CENTER_HORIZONTAL
        toastMessage.textSize = 30f
        toastMessage.typeface = Typeface.DEFAULT_BOLD
        toast.show()
    }

    fun showXMLToastMessage(view: View) {
        val toast = Toast.makeText(this, "", Toast.LENGTH_SHORT)
        val toastLayout = layoutInflater.inflate(R.layout.custom_toast_layout, null)
        toast.view = toastLayout
        toast.setGravity(Gravity.TOP, 0, 300)
        toastLayout.setBackgroundColor(Color.BLUE)

        toast.show()
    }

    fun writeToEditText(view: View) {
        val myEditText = findViewById<EditText>(R.id.my_edit_text)
        myEditText.setText("ALO")
    }

    fun showFingerGame(view: View) {
        val intent = Intent(this, HowManyFingersActivity::class.java)
        startActivity(intent)
    }

    fun showBMI(view: View) {
        val intent = Intent(this, BMIActivity::class.java)
        startActivity(intent)
    }

    fun showCalculator(view: View) {
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }
}
