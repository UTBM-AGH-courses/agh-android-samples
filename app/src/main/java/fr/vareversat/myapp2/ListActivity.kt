package fr.vareversat.myapp2

import FlowerNameAdapter
import android.app.Dialog
import android.os.Bundle
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.input_box_layout.*

class ListActivity : AppCompatActivity() {

    private val listOfFlowers = ArrayList<String>()
    private val listOfFlowersImageIDs = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        initializeFlowerList()
        val adapter = FlowerNameAdapter(this, listOfFlowers, listOfFlowersImageIDs)
        flower_list.adapter = adapter
        flower_list.setOnItemClickListener { parent, view, position, id ->
            showFlowerNameInputBox(listOfFlowers[position], position, adapter)
        }
    }

    private fun showFlowerNameInputBox(oldName: String, position: Int, adapter: FlowerNameAdapter) {
        val dialog = Dialog(this)
        dialog.setTitle("Edit flower name")
        dialog.setContentView(R.layout.input_box_layout)
        dialog.input_text.setText(oldName)
        dialog.btn_update.setOnClickListener {
            listOfFlowers[position] = dialog.input_text.text.toString()
            (adapter as BaseAdapter).notifyDataSetChanged()
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun initializeFlowerList() {
        listOfFlowers.add("Roza")
        listOfFlowers.add("Frezja")
        listOfFlowers.add("Bratek")
        listOfFlowers.add("Stokrotka")
        listOfFlowers.add("Przebisnieg")
        listOfFlowers.add("Krokus")
        listOfFlowers.add("Gozdzik")
        listOfFlowers.add("Tulipan")
        listOfFlowers.add("Aster")
        listOfFlowers.add("Chaber")
        listOfFlowers.add("Krokus")
        listOfFlowers.add("Gozdzik")
        listOfFlowers.add("Tulipan")
        listOfFlowers.add("Aster")
        listOfFlowers.add("Chaber")

        listOfFlowersImageIDs.add(R.drawable.roza)
        listOfFlowersImageIDs.add(R.drawable.roza)
        listOfFlowersImageIDs.add(R.drawable.roza)
        listOfFlowersImageIDs.add(R.drawable.roza)
        listOfFlowersImageIDs.add(R.drawable.roza)
        listOfFlowersImageIDs.add(R.drawable.roza)
        listOfFlowersImageIDs.add(R.drawable.roza)
        listOfFlowersImageIDs.add(R.drawable.roza)
        listOfFlowersImageIDs.add(R.drawable.roza)
        listOfFlowersImageIDs.add(R.drawable.roza)
        listOfFlowersImageIDs.add(R.drawable.roza)
        listOfFlowersImageIDs.add(R.drawable.roza)
        listOfFlowersImageIDs.add(R.drawable.roza)
        listOfFlowersImageIDs.add(R.drawable.roza)
        listOfFlowersImageIDs.add(R.drawable.roza)
    }
}