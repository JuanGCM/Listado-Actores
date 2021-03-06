package com.example.listadoapp.ui.actores

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.listadoapp.R
import com.example.listadoapp.ui.Actor

import com.example.listadoapp.ui.actores.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyActoresListRecyclerViewAdapter(
    private var values: List<Actor>
) : RecyclerView.Adapter<MyActoresListRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_actores, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.nombre.text = item.name
        holder.popularidad.text = item.popularity.toString()
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre: TextView = view.findViewById(R.id.nombre)
        val popularidad: TextView = view.findViewById(R.id.popu)

    }

    fun setData(newActor: List<Actor>) {
        this.values = newActor

        notifyDataSetChanged()
    }
}