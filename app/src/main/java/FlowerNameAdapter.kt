import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import fr.vareversat.myapp2.R
import kotlinx.android.synthetic.main.flower_list_item.view.*

class FlowerNameAdapter(
    var context: Context,
    var flowerNames: ArrayList<String>,
    var flowerImages: ArrayList<Int>
) : BaseAdapter() {

    override fun getCount(): Int {
        return flowerNames.size
    }

    override fun getItem(p0: Int): Any {
        return flowerNames[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = layoutInflater.inflate(R.layout.flower_list_item, null, true)
        val flowerNameTextView = itemView.flower_name as TextView
        val flowerImageView = itemView.flower_image as ImageView
        flowerNameTextView.text = getItem(p0).toString()
        if (p0 % 2 == 0) {
            flowerNameTextView.background =
                ContextCompat.getDrawable(context, android.R.color.holo_green_light)
        } else {
            flowerNameTextView.background =
                ContextCompat.getDrawable(context, android.R.color.darker_gray)
        }
        flowerImageView.setImageResource(flowerImages[p0])
        return itemView
    }
}