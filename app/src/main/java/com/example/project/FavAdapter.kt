package com.example.project

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FavAdapter(
    val nameAnimal: MutableList<String>,
    val imageAnimal: MutableList<Int>,
    val soundAnimal: MutableList<Int>,
    val favAnimal: MutableList<Boolean>
):
    RecyclerView.Adapter<FavAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtAnim=view.findViewById<TextView>(R.id.animal_name)
        val imgAnim=view.findViewById<ImageView>(R.id.animal_image)
        val favAnim=view.findViewById<CheckBox>(R.id.animal_fav)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.fav_item,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtAnim.text=nameAnimal[position]
        holder.imgAnim.setImageResource(imageAnimal[position])
       holder.favAnim.isChecked=favAnimal[position]

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