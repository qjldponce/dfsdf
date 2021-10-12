package com.example.prelim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import retrofit2.Response

class EducAdapter(private val data: List<EducAttributes>) : RecyclerView.Adapter<EducAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){

        fun bind(response: EducAttributes){
            val id = view.findViewById<TextView>(R.id.IdView)
            val title = view.findViewById<TextView>(R.id.nameView)
            val description = view.findViewById<TextView>(R.id.description)
            val imageView = view.findViewById<ImageView>(R.id.imageview)

            id.text = response.media_type
            title.text = response.title
            description.text = response.description

            Glide.with(view.context).load(response.url).centerCrop().into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.sample_educ, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }
}