package com.example.libraryofohara

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryofohara.Adaptador.AdaptadorLibros
import com.example.libraryofohara.Models.Libro
import com.example.libraryofohara.Models.LibroUsuario
import com.example.libraryofohara.databinding.FragmentPaginaUsuarioBinding

class PaginaUsuarioFragment : Fragment() {
    lateinit var binding: FragmentPaginaUsuarioBinding
    lateinit var recycler: RecyclerView
    lateinit var adapter: AdaptadorLibros
    var librosUsuario = mutableListOf<LibroUsuario>()

    override fun onResume() {
        super.onResume()
        librosUsuario.clear()
        librosUsuario.addAll(PaginaUsuario.librosUsuario)
        Log.e("cont libros", librosUsuario.size.toString())
        iniciarRecycler()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaginaUsuarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun iniciarRecycler() {
        var libros = mutableListOf<Libro>()
        librosUsuario.forEach { libroUsuario: LibroUsuario ->
            if (libroUsuario.usuario.nombre.equals(
                    PaginaUsuario.usuario!!.nombre,
                    ignoreCase = true
                )
            ) {
                libros.add(libroUsuario.libro)
            }
        }
        recycler = binding.recyclerLibrosUsuario
        if (libros.size == 0) {
            recycler.visibility = View.INVISIBLE
            binding.textoInicio.visibility = View.VISIBLE

        } else {
            recycler.visibility = View.VISIBLE
            binding.textoInicio.visibility = View.INVISIBLE
        }
        recycler.layoutManager = LinearLayoutManager(context)
        adapter = AdaptadorLibros(
            libros
        ) { pos ->
            val usuarioLibro = librosUsuario.get(pos)
            val intent = Intent(this.requireContext(), DetalleLibro::class.java)
            intent.putExtra("titulo", usuarioLibro.libro.titulo)
            startActivity(intent)
        }
        recycler.adapter = adapter
    }
}