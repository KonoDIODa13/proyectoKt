package com.example.libraryofohara.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.libraryofohara.Models.Libro
import com.example.libraryofohara.R
import com.example.libraryofohara.databinding.ElementoLibroBinding

class AdaptadorLibros(var libros: List<Libro>) :
    RecyclerView.Adapter<AdaptadorLibros.ViewHolderLibros>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLibros {
        val minflater = LayoutInflater.from(parent.context)

        val miView = minflater.inflate(R.layout.elemento_libro, parent, false)
        return ViewHolderLibros(miView)
    }

    override fun getItemCount(): Int = libros.size


    override fun onBindViewHolder(holder: ViewHolderLibros, position: Int) {
        holder.mostrar(libros.get(position))
    }

    class ViewHolderLibros(val vista: View) : ViewHolder(vista) {
        val binding = ElementoLibroBinding.bind(vista)
        fun mostrar(libro: Libro) {
            binding.tvTitulo.text = libro.titulo
        }
    }
}