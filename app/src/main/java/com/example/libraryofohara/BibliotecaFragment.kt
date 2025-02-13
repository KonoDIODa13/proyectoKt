package com.example.libraryofohara


import android.content.Intent
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
        binding = FragmentBibliotecaBinding.inflate(inflater, container, false)
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
        adapter = AdaptadorLibros(
            libros,
            { pos ->
            var libro = libros.get(pos)
            var intent = Intent(this.requireContext(), DetalleLibro::class.java)
            intent.putExtra("titulo", libro.titulo)
            startActivity(intent)
        }
        )
        recycler.adapter = adapter
    }
}