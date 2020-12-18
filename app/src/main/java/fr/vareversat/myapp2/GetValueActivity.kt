package fr.vareversat.myapp2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_get_value.*

class GetValueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_value)
        passed_value.text = intent.getStringExtra("valueToBePassed")
    }
}