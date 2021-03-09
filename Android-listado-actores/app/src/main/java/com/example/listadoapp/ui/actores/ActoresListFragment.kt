package com.example.listadoapp.ui.actores

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.listadoapp.R
import com.example.listadoapp.ui.Actor
import com.example.listadoapp.ui.actores.dummy.DummyContent

/**
 * A fragment representing a list of Items.
 */
class ActoresListFragment : Fragment() {

    private lateinit var actoresViewModel: ActoresViewModel
    var listaActores: List<Actor> = listOf()
    lateinit var listaAdapter: MyActoresListRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_actores_list, container, false)

        actoresViewModel =
            ViewModelProvider(this).get(ActoresViewModel::class.java)

        val v = view as RecyclerView

        listaAdapter = MyActoresListRecyclerViewAdapter(listaActores)
        v.layoutManager = LinearLayoutManager(context)
        v.adapter= listaAdapter

        actoresViewModel.actores.observe(viewLifecycleOwner, Observer {
                actores -> listaActores = actores
            listaAdapter.setData(actores.sortedWith(compareBy({ it.name })))
        })

        return view
    }
}