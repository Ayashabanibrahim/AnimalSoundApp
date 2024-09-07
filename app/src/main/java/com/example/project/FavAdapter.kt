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
    val favItemName: MutableList<String>,
    val favItemImage: MutableList<Int>,
    val favItemSound: MutableList<Int>,
    val myItemsFav: MutableList<Boolean>
):
    RecyclerView.Adapter<FavAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val favItemText=view.findViewById<TextView>(R.id.item_name)
        val favItemImg=view.findViewById<ImageView>(R.id.item_image)
        val myFavItem=view.findViewById<CheckBox>(R.id.item_check)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.fav_item,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.favItemText.text=favItemName[position]
        holder.favItemImg.setImageResource(favItemImage[position])
       holder.myFavItem.isChecked=myItemsFav[position]

        holder.favItemImg.setOnClickListener {
            mediaPlayer2?.stop()
            mediaPlayer2?.release()
            val mediaPlayer = MediaPlayer.create(holder.itemView.context, favItemSound[position])
            mediaPlayer.start()
            mediaPlayer2 = mediaPlayer
        }

    }
    override fun getItemCount(): Int {
        return favItemName.size
    }
}