package com.example.quiz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz.databinding.FragmentAnswerBinding
import com.example.quiz.databinding.FragmentQuestionsBinding

 class answer : Fragment(){
    private var _binding : FragmentAnswerBinding? = null
    private val binding get()=_binding!!
    private lateinit var recyclerView: RecyclerView
     var total_score:Int =0
     var name:String =""
     var question_list:ArrayList<String> = ArrayList()
     var answer_list:ArrayList<String> =ArrayList()
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
         arguments?.let {
             val args=answerArgs.fromBundle(it)
             question_list.addAll(args.questionArraylist)
             answer_list.addAll(args.answerArraylist)
              total_score=args.score
              name = args.name
         }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentAnswerBinding.inflate(inflater,container,false)
        val view=binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView= binding.recyclerView
       recyclerView.adapter=answer_adapter(question_list,answer_list)
        binding.menuAnswer.setOnClickListener {
            val action=answerDirections.actionAnswer2ToMainScreen(
                    pName = name,PScore = total_score)
            findNavController().navigate(action)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}
