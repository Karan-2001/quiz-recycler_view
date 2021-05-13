package com.example.quiz

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class question_adapter(
        private val int :Click
):
    RecyclerView.Adapter
    <question_adapter.question_viewHolder>() {
    var data = Obj_list().send_obj().toList()
    var _data = data.shuffled().take(5)
    val filter_data = _data
    var state: ArrayList<Int> = arrayListOf(-1, -1, -1, -1, -1)

    class question_viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val question = view.findViewById<TextView>(R.id.questions)
        val A = view.findViewById<Button>(R.id.option_A)
        val B = view.findViewById<Button>(R.id.option_B)
        val C = view.findViewById<Button>(R.id.option_C)
        val D = view.findViewById<Button>(R.id.option_D)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): question_viewHolder {
        val layout = LayoutInflater.from(parent.context)
                .inflate(R.layout.question_display, parent, false)
        return question_viewHolder(layout)
    }

    override fun onBindViewHolder(holder: question_viewHolder, position: Int) {
        val item = filter_data[position]

       // holder.question.text = "${position + 1}) " + "${item.question}"
        holder.question.setText("${position + 1}) " + "${item.question}")
        //holder.question.setTextSize(10F)
        holder.A.text = "A) " + "${item.options_list[0]}"
        holder.B.text = "B) " + "${item.options_list[1]}"
        holder.C.text = "C) " + "${item.options_list[2]}"
        holder.D.text = "D) " + "${item.options_list[3]}"
        //holder.question.setBackgroundColor(Color.parseColor("#38D9DC"))
        holder.A.setOnClickListener {
            holder.A.setBackgroundColor(Color.BLUE)
            holder.B.setBackgroundColor(Color.parseColor("#9C27B0"))
            holder.C.setBackgroundColor(Color.parseColor("#9C27B0"))
            holder.D.setBackgroundColor(Color.parseColor("#9C27B0"))
            state[position] = 0
            Log.e("onnclick", "A")
        }
        holder.B.setOnClickListener {
            holder.B.setBackgroundColor(Color.BLUE)
            holder.A.setBackgroundColor(Color.parseColor("#9C27B0"))
            holder.C.setBackgroundColor(Color.parseColor("#9C27B0"))
            holder.D.setBackgroundColor(Color.parseColor("#9C27B0"))
            state[position] = 1
            Log.e("onnclick", "B")
        }
        holder.C.setOnClickListener {
            holder.C.setBackgroundColor(Color.BLUE)
            holder.B.setBackgroundColor(Color.parseColor("#9C27B0"))
            holder.A.setBackgroundColor(Color.parseColor("#9C27B0"))
            holder.D.setBackgroundColor(Color.parseColor("#9C27B0"))
            state[position] = 2

            Log.e("onnclick", "C")
        }
        holder.D.setOnClickListener {
            holder.D.setBackgroundColor(Color.BLUE)
            holder.B.setBackgroundColor(Color.parseColor("#9C27B0"))
            holder.C.setBackgroundColor(Color.parseColor("#9C27B0"))
            holder.A.setBackgroundColor(Color.parseColor("#9C27B0"))
            state[position] = 3

            Log.e("onnclick", "D")
        }
        Log.e("on", "array:${state}")
        int.go_to_main(state,filter_data)
    }

    override fun getItemCount(): Int {
        return filter_data.size
    }

    interface Click {
        fun go_to_main(R_id: ArrayList<Int>,filter_data:List<data_class>)
    }
}