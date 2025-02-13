package com.example.libraryofohara.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryofohara.Extensions.cargarImagen
import com.example.libraryofohara.Models.Libro
import com.example.libraryofohara.R

import com.example.libraryofohara.databinding.ElementoLibroBinding

class AdaptadorLibros(var libros: List<Libro>, var verDetalle: (Int) -> Unit) :
    RecyclerView.Adapter<AdaptadorLibros.HolderLibros>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderLibros {
        return HolderLibros(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.elemento_libro, parent, false)
        )
    }

    override fun getItemCount(): Int = libros.size


    override fun onBindViewHolder(holder: HolderLibros, position: Int) {
        holder.mostrar(libros.get(position))
        holder.vista.setOnClickListener {
            verDetalle(position)
        }

    }

    class HolderLibros(val vista: View) : RecyclerView.ViewHolder(vista) {
        val binding = ElementoLibroBinding.bind(vista)

        fun mostrar(libro: Libro) {
            binding.tvTitulo.text = libro.titulo
            binding.ivPortada.cargarImagen(libro.portada)
        }
    }
}