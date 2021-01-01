package org.ovechka.shamankingspirits

import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class SpiritsAdapter(
    private val spirits: List<Spirit>,
     val context: Context
) : RecyclerView.Adapter<SpiritsAdapter.SpiritVH>() {

    class SpiritVH(view: View) : RecyclerView.ViewHolder(view){

        val photo = view.findViewById<ImageView>(R.id.image)
        val name = view.findViewById<TextView>(R.id.name)

        fun setData(spirit: Spirit, context: Context){
            if (spirit.href != "No photo"){
                Picasso.get().load(spirit.photo).into(photo)
                Log.i("duck", spirit.photo)
            }
            name.text = spirit.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpiritVH {
       val view = LayoutInflater.from(context).inflate(R.layout.spirit_list_item, parent, false)
        return SpiritVH(view)

    }

    override fun onBindViewHolder(holder: SpiritVH, position: Int) {
        holder.setData(spirits[position], context)
    }

    override fun getItemCount(): Int {
        return spirits.size
    }
}