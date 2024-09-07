package com.example.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.databinding.FragmentBirdBinding



class BirdFragment : Fragment() {
   lateinit var binding: FragmentBirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentBirdBinding.inflate(layoutInflater)
        birdName= arrayOf(
            "Parrot",
            "Raven",
            "Woodpecker",
            "Tawny Frogmouth",
            "Sparrow",
            "Snowy Owl",
            "Canary",
            "Nightingale",
            "Amazon Macaw",
            "Finch",
            "Peacock",
            "Gull",
            "Lapwing ",
            "swallow",
        )
        birdImage= arrayOf(
            R.drawable.img_8,
            R.drawable.img_9,
            R.drawable.img_10,
            R.drawable.img_11,
            R.drawable.img_12,
            R.drawable.img_13,
            R.drawable.img_14,
            R.drawable.img_15,
            R.drawable.img_16,
            R.drawable.img_18,
            R.drawable.img_17,
            R.drawable.img_19,
            R.drawable.img_20,
            R.drawable.img_21,


            )
        birdSound= arrayOf(
            R.raw.parot,
            R.raw.rabe,
            R.raw.specht,
            R.raw.australianfrogmouth,
            R.raw.spatz,
            R.raw.owl,
            R.raw.kanarienvogel,
            R.raw.nachtigal,
            R.raw.amazonmacaw,
            R.raw.finch,
            R.raw.peacock,
            R.raw.moewe,
            R.raw.lapwing,
            R.raw.schwalbe,

            )


        val birdAdapter=BirdAdapter(birdName,birdImage,birdSound,birdFav)
        val animalRecyclerView=binding.birdRecy
        animalRecyclerView.adapter=birdAdapter
        animalRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as MainActivity).supportActionBar?.title="Sound Animal"
    }




}