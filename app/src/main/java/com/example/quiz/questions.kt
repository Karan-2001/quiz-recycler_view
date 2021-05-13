package com.example.quiz

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz.databinding.FragmentQuestionsBinding
import kotlinx.coroutines.NonCancellable.cancel
import kotlinx.coroutines.delay

class questions : Fragment(),question_adapter.Click {
    private var _binding : FragmentQuestionsBinding? = null
    private val binding get() =_binding!!
    private lateinit var recyclerView: RecyclerView
     lateinit var states : ArrayList<Int>
    lateinit var data : List<data_class>
    private var name:String =""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            val args=questionsArgs.fromBundle(it)
            name=args.name
        }
    }
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentQuestionsBinding.inflate(inflater, container, false)
        val view=binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView= binding.recyclerView
        recyclerView.adapter=question_adapter(this)

        val timer = object : CountDownTimer(30000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                if(millisUntilFinished>10000){
                    binding.timertext.text="00:"+millisUntilFinished/1000
                }

                else{
                    if (millisUntilFinished<= 1000){
                        Log.e("AA", "1 sec")
                        makeText(requireContext(),"Auto-Submitting ", LENGTH_SHORT).show()

                    }

                    binding.timertext.setTextColor(Color.RED)
                    binding.timertext.text="00:0"+millisUntilFinished/1000
                }
            }

            override fun onFinish() {
                submit()
            }
        }.start()

        binding.submit.setOnClickListener {
            timer.cancel()
            submit()
        }
        }

    private fun submit() {
        var score :Int =0
        var j=0
        for( i in states)
        {
            if(i == data[j].opt) score+=5
            j+=1
        }
        var question_list : ArrayList<String> = arrayListOf(data[0].question,data[1].question,data[2].question,
                data[3].question,data[4].question)
        var answer_list : ArrayList<String> = arrayListOf(data[0].answerkey,data[1].answerkey,data[2].answerkey,
                data[3].answerkey,data[4].answerkey)
        Log.e("question","${question_list}")
        Log.e("answer","${answer_list}")
        val action =questionsDirections.actionQuestions2ToScoreBoard(score =score,
                questionArrayList = question_list.toTypedArray(), answerArrayList = answer_list.toTypedArray()
        ,name=name)
        findNavController().navigate(action)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun go_to_main(R_id: ArrayList<Int>, filter_data: List<data_class>) {
      data=filter_data
        states=R_id
        Log.e("AA", "array${R_id}")
    }

}

