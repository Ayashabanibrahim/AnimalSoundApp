package com.example.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.project.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
      lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
         binding= FragmentHomeBinding.inflate(layoutInflater)
         return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //val animBtn=view.findViewById<Button>(R.id.animal_btn)

        binding.animalBtn.setOnClickListener{
            (activity as MainActivity).supportActionBar?.title=null
            findNavController().navigate(R.id.action_homeFragment_to_animalFragment)
        }
        binding.birdsBtn.setOnClickListener{
            (activity as MainActivity).supportActionBar?.title=null
            findNavController().navigate(R.id.action_homeFragment_to_birdFragment)
        }
    }


}