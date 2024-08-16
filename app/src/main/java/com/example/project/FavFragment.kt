package com.example.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.databinding.FragmentFavBinding


class FavFragment : Fragment() {
    lateinit var binding: FragmentFavBinding
     var animalNameFav= mutableListOf<String>()
      var animalImageFav= mutableListOf<Int>()
     var animalSoundFav=mutableListOf<Int>()
      var myFav=mutableListOf<Boolean>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentFavBinding.inflate(layoutInflater)


        for(i in animalFav.indices){
            if(animalFav[i]){
                animalImageFav.add(animalImage[i])
                animalSoundFav.add(animalSound[i])
                animalNameFav.add( animalName[i])
                myFav.add(true)
            }

        }

        for(i in birdFav.indices){
            if(birdFav[i]){
                animalImageFav.add(birdImage[i])
                animalSoundFav.add(birdSound[i])
                animalNameFav.add(birdName[i])
                myFav.add(true)
            }

        }






        val favAdapter=FavAdapter(animalNameFav,animalImageFav,animalSoundFav,myFav)
        val favRecyclerView=binding.favRecy
        favRecyclerView.adapter=favAdapter
        favRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        return binding.root
    }


}