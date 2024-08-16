package com.example.project

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BirdAdapter(val nameBird:Array<String>,val imageBird:Array<Int>,val soundBird:Array<Int>,val favBird:Array<Boolean>):RecyclerView.Adapter<BirdAdapter.ViewHolder>(){
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val txtAnim=view.findViewById<TextView>(R.id.animal_name)
        val imgAnim=view.findViewById<ImageView>(R.id.animal_image)
        val favAnim=view.findViewById<CheckBox>(R.id.animal_fav)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.animal_item,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtAnim.text=nameBird[position]
        holder.imgAnim.setImageResource(imageBird[position])
        //val iconResource=if(favAnimal[position]) R.drawable.baseline_favorite_24
        // else R.drawable.favorite_24
        holder.favAnim.isChecked=favBird[position]
        holder.favAnim.setOnCheckedChangeListener{
                buttonView,isCheced ->
            birdFav[position]=isCheced
        }
        holder.imgAnim.setOnClickListener {
            mediaPlayer2?.stop()
            mediaPlayer2?.release()
            val mediaPlayer = MediaPlayer.create(holder.itemView.context, soundBird[position])
            mediaPlayer.start()
            mediaPlayer2 = mediaPlayer
        }

    }
    override fun getItemCount(): Int {
        return nameBird.size
    }
}