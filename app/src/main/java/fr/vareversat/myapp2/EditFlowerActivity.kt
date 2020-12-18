package fr.vareversat.myapp2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit_flower.*

class EditFlowerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_flower)
        flower_name_edit.setText(intent.getStringExtra("valueToBePassed"))
    }

    fun commitChanges(view: View) {
        val intent = Intent()
        intent.putExtra("editTextValue", flower_name_edit.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}