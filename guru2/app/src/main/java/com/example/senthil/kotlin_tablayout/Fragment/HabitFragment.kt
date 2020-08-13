package com.example.senthil.kotlin_tablayout.Fragment


//import android.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import com.example.senthil.kotlin_tablayout.R
import kotlinx.android.synthetic.main.fragment_habit.*


class HabitFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_habit)
        // Initializing the array lists and the adapter
        var itemlist = arrayListOf<String>()
        var adapter =ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice
                , itemlist)
        // Adding the items to the list when the add button is pressed
        add.setOnClickListener {

            itemlist.add(editText.text.toString())
            listView.adapter =  adapter
            adapter.notifyDataSetChanged()
            // This is because every time when you add the item the input space or the eidt text space will be cleared
            editText.text.clear()
        }
        // Clearing all the items in the list when the clear button is pressed
        clear.setOnClickListener {

            itemlist.clear()
            adapter.notifyDataSetChanged()
        }
        // Adding the toast message to the list when an item on the list is pressed
        listView.setOnItemClickListener { adapterView, view, i, l ->
            android.widget.Toast.makeText(this, "습관 "+itemlist.get(i)+"을 완료하였습니다.", android.widget.Toast.LENGTH_SHORT).show()
        }
        // Selecting and Deleting the items from the list when the delete button is pressed
        delete.setOnClickListener {
            val position: SparseBooleanArray = listView.checkedItemPositions
            val count = listView.count
            var item = count - 1
            while (item >= 0) {
                if (position.get(item))
                {
                    adapter.remove(itemlist.get(item))
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()
        }
    }
}
