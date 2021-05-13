package com.example.quiz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.quiz.databinding.FragmentMainScreenBinding

class main_screen : Fragment() {

    private var _binding : FragmentMainScreenBinding? =null
    private val binding get()=_binding!!
    private var name :String = ""
    private var score :Int = 0

    var name_list:ArrayList<String> = ArrayList()
    var score_list:ArrayList<Int> =ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            val args=main_screenArgs.fromBundle(it)
             name = args.pName
             score= args.PScore

        }
        if(savedInstanceState != null)
        {
                name_list.add(savedInstanceState.getString("name").toString())
                score_list.add(savedInstanceState.getInt("score"))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("name", name)
        outState.putInt("score", score)
        Log.e("CAlled", "onSaveInstanceState Called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentMainScreenBinding.inflate(inflater,container,false)
        val view=binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        onplay()
        binding.start.setOnClickListener {
            name = binding.name.text.toString()
            if(name.isEmpty())
            {
                Toast.makeText(requireContext(), "Enter name!!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(), "Welcome ${name} !! ", Toast.LENGTH_SHORT).show()
                val action=main_screenDirections.actionMainScreenToQuestions2(name= name)
               findNavController().navigate(action)
            }
            Log.e("names","names:${name_list}")
            Log.e("scores","score:${score_list}")

        }
    }

    private fun onplay() {

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    }