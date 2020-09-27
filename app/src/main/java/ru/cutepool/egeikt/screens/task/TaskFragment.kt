package ru.cutepool.egeikt.screens.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_task.view.*
import ru.cutepool.egeikt.R

class TaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_task, container, false)

        val toolbar = view.frg_task__toolbar

        val swipeStack = view.frg_task__swipe_stack
        swipeStack.adapter = SwipeStackAdapter(layoutInflater, listOf("card1", "card2", "card3", "card4", "card5"))

        return view
    }

    companion object {
        fun newInstance(): TaskFragment = TaskFragment()
    }

    class SwipeStackAdapter(private val layoutInflater: LayoutInflater, private val data: List<String>) : BaseAdapter() {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view = layoutInflater.inflate(R.layout.card_task, parent, false)
            val textViewCard = view.findViewById<TextView>(R.id.card_task__tv)
            textViewCard.text = data[position]

            return view
        }

        override fun getItem(position: Int): Any {
            return data[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return data.size
        }

    }
}