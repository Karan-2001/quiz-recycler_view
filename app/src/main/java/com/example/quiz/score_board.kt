package com.example.quiz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.navigation.fragment.findNavController
import com.example.quiz.databinding.FragmentScoreBoardBinding

class score_board : Fragment() {
    private var _binding : FragmentScoreBoardBinding? = null
    private val binding get()=_binding!!
    var total_score:Int =0
    var name:String =""
    var question_list:ArrayList<String> = ArrayList()
    var answer_list:ArrayList<String> =ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            val args=score_boardArgs.fromBundle(it)
             question_list.addAll(args.questionArrayList)
            answer_list.addAll(args.answerArrayList)
            total_score = args.score
            name=args.name
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentScoreBoardBinding.inflate(inflater,container,false)
        val view=binding.root
        return view
    }
    //@SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

       binding.score.text="${total_score}/25"
        binding.yourScore.text=name
        binding.share.setOnClickListener {
            val shareintent = ShareCompat.IntentBuilder.from(requireActivity())
                    .setText("Score:" + total_score + "\n#QUIZ APP -By Karan")
                    .setType("text/plain")
                    .intent
                startActivity(shareintent)

        }
       binding.menuScore.setOnClickListener {
           val action=score_boardDirections.actionScoreBoardToMainScreen(pName = name,PScore = total_score)
           findNavController().navigate(action)
       }
        binding.AnswerS.setOnClickListener {
            val action =score_boardDirections.actionScoreBoardToAnswer2(questionArraylist = question_list.toTypedArray(),
            answerArraylist = answer_list.toTypedArray(),score=total_score,name=name)
            findNavController().navigate(action)
            Log.e("question","${question_list}")
            Log.e("answer","${answer_list}")
       }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    }
