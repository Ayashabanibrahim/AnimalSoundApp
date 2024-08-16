package com.example.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.project.databinding.FragmentFirstkBinding

class FirstkFragment : Fragment() {
      lateinit var binding:FragmentFirstkBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
         binding=FragmentFirstkBinding.inflate(layoutInflater)
         return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //val animBtn=view.findViewById<Button>(R.id.animal_btn)

        binding.animalBtn.setOnClickListener{
            findNavController().navigate(R.id.action_firstkFragment_to_secondFragment)
        }
        binding.birdsBtn.setOnClickListener{
            findNavController().navigate(R.id.action_firstkFragment_to_thirdFragment)
        }
    }


}