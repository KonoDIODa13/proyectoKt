package com.example.libraryofohara.Views.Fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryofohara.Adaptador.AdaptadorLibros
import com.example.libraryofohara.Providers.Provider
import com.example.libraryofohara.databinding.FragmentBibliotecaBinding


class BibliotecaFragment : Fragment() {
    lateinit var binding: FragmentBibliotecaBinding
    lateinit var recycler: RecyclerView
    lateinit var adapter: AdaptadorLibros

    @RequiresApi(Build.VERSION_CODES.O)
    var libros = Provider.listaLibro

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBibliotecaBinding.inflate(layoutInflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniciarRecycler()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun iniciarRecycler() {
        recycler = binding.recyclerLibros
        recycler.layoutManager = LinearLayoutManager(context)
        adapter = AdaptadorLibros(libros)
    }
}