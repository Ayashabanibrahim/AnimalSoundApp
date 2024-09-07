package com.example.project

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BirdAdapter(val nameBird:Array<String>,val imageBird:Array<Int>,val soundBird:Array<Int>,val favBird:Array<Boolean>)
    :RecyclerView.Adapter<BirdAdapter.ViewHolder>(){
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val txtBird=view.findViewById<TextView>(R.id.item_name)
        val imgBird=view.findViewById<ImageView>(R.id.item_image)
        val favBird=view.findViewById<CheckBox>(R.id.item_check)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.animal_item,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtBird.text=nameBird[position]
        holder.imgBird.setImageResource(imageBird[position])
        holder.favBird.setOnCheckedChangeListener(null)
        holder.favBird.isChecked=favBird[position]
        holder.favBird.setOnCheckedChangeListener{
                buttonView,isCheced ->
            birdFav[position]=isCheced
        }
        holder.imgBird.setOnClickListener {
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