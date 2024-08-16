package com.example.project

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimlAdapter (val nameAnimal:Array<String>,val imageAnimal:Array<Int>,val soundAnimal:Array<Int>,val favAnimal:Array<Boolean>):RecyclerView.Adapter<AnimlAdapter.MyViewHolder>(){
    class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
       val txtAnim=view.findViewById<TextView>(R.id.animal_name)
        val imgAnim=view.findViewById<ImageView>(R.id.animal_image)
        val favAnim=view.findViewById<CheckBox>(R.id.animal_fav)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.animal_item,parent,false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         holder.txtAnim.text=nameAnimal[position]
        holder.imgAnim.setImageResource(imageAnimal[position])
        //val iconResource=if(favAnimal[position]) R.drawable.baseline_favorite_24
       // else R.drawable.favorite_24
         holder.favAnim.isChecked=favAnimal[position]
        holder.favAnim.setOnCheckedChangeListener{
            buttonView,isCheced ->
            animalFav[position]=isCheced
        }

        holder.imgAnim.setOnClickListener {
             mediaPlayer2?.stop()
            mediaPlayer2?.release()
            val mediaPlayer = MediaPlayer.create(holder.itemView.context, soundAnimal[position])
            mediaPlayer.start()
            mediaPlayer2 = mediaPlayer
        }


    }




    override fun getItemCount(): Int {
       return nameAnimal.size
    }
}