package com.example.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=FragmentSecondBinding.inflate(layoutInflater)
      val view= binding.root

        animalImage= arrayOf(
            R.drawable.img_2,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.bull,
            R.drawable.cat,
            R.drawable.cows,
            R.drawable.elk,
            R.drawable.fox,
            R.drawable.loewen,
            R.drawable.nashorn,
            R.drawable.pony,
            R.drawable.sheep,
            R.drawable.wolf,
            R.drawable.horse,

            )
        animalName= arrayOf(
            "Taiger",
            "Elephant",
            "Chimp",
            "Bull",
            "Cat",
            "Cow",
            "Elk",
            "Fox",
            "Lion",
            "Rhino",
            "Pony",
            "Sheep",
            "Wolf",
            "Horse",
        )
        animalSound= arrayOf(
            R.raw.tiger,
            R.raw.elefant,
            R.raw.schimpanse,
            R.raw.ochse,
            R.raw.cat,
            R.raw.caw,
            R.raw.elk,
            R.raw.fox,
            R.raw.loin,
            R.raw.rhinozerus,
            R.raw.pony,
            R.raw.schafe,
            R.raw.wolf,
            R.raw.pferd_whinnert

        )

        val animalAdapter=AnimlAdapter(animalName,animalImage,animalSound,animalFav)
        val animalRecyclerView=binding.animalRecy
        animalRecyclerView.adapter=animalAdapter
        animalRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        return view

    }





}