package com.example.mymusicplayer

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val dataList: List<Data>):

        RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.each_song,parent,false)
        return MyViewHolder(itemView)


    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        val currentData = dataList[position]
        val mediaPlayer = MediaPlayer.create(context, currentData.preview.toUri())
        holder.title.text = currentData.title


        Picasso.get().load(currentData.album.cover).into(holder.img);

        holder.play.setOnClickListener {
            mediaPlayer.start()
        }

        holder.pause.setOnClickListener {
            mediaPlayer.stop()
        }

    }


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val img: ImageView
        val title: TextView
        val play: ImageButton
        val pause: ImageButton

        init {
            img = itemView.findViewById(R.id.iv_song_cover)
            title = itemView.findViewById(R.id.tv_song_title)
            play = itemView.findViewById(R.id.play_btn)
            pause = itemView.findViewById(R.id.pause_btn)
        }

    }

}