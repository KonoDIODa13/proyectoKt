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
import com.example.libraryofohara.Models.Libro
import com.example.libraryofohara.Models.LibroUsuario
import com.example.libraryofohara.databinding.FragmentBibliotecaBinding
import com.example.libraryofohara.databinding.FragmentPaginaUsuarioBinding

class PaginaUsuarioFragment : Fragment() {
    lateinit var binding: FragmentPaginaUsuarioBinding
    lateinit var recycler: RecyclerView
    lateinit var adapter: AdaptadorLibros
    var librosUsuario = PaginaUsuario.librosUsuario
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaginaUsuarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniciarRecycler()
    }

    private fun iniciarRecycler() {
        var libros= mutableListOf<Libro>()
        librosUsuario.forEach { libroUsuario: LibroUsuario ->
            libros.add(libroUsuario.libro)
        }
        recycler = binding.recyclerLibrosUsuario
        if (libros.size==0) {
            recycler.visibility=View.INVISIBLE
            binding.textoInicio.visibility=View.VISIBLE

        }else{
            recycler.visibility=View.VISIBLE
            binding.textoInicio.visibility=View.INVISIBLE
        }
        recycler.layoutManager = LinearLayoutManager(context)
        adapter = AdaptadorLibros(
            libros,
            { pos ->
                var usuarioLibro = librosUsuario.get(pos)
                var intent = Intent(this.requireContext(), DetalleLibro::class.java)
                intent.putExtra("titulo", usuarioLibro.libro.titulo)
                startActivity(intent)
            }
        )
        recycler.adapter = adapter
    }
}