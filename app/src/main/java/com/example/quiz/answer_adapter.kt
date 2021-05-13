package com.example.quiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class answer_adapter(
        val question_list : ArrayList<String>,
        val answer_list : ArrayList<String>,
):
    RecyclerView.Adapter
    <answer_adapter.answer_viewHolder>() {
    var data = Obj_list().send_obj().toList().shuffled().take(5)
    //var question_list : List<data_class> = data
        class answer_viewHolder(view: View):RecyclerView.ViewHolder(view){
        val question=view.findViewById<TextView>(R.id.questions_answer)
        val answer = view.findViewById<TextView>(R.id.answer)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            answer_viewHolder {
     val layout=LayoutInflater.from(parent.context)
         .inflate(R.layout.answer_display,parent,false)
        return answer_viewHolder(layout)
    }

    override fun onBindViewHolder(holder: answer_viewHolder, position: Int) {
        val ques=question_list[position]
        val ans=answer_list[position]

        holder.question.text="${position+1}) "+"${ques}"
        holder.answer.text=ans
        }


    override fun getItemCount(): Int {
      return question_list.size
    }

//    override fun go_to_main(R_id: ArrayList<Int>, filter_data: List<data_class>) {
//        question_list=filter_data
//    }
}