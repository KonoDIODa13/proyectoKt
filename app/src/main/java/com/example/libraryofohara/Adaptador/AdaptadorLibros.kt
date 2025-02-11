package com.example.libraryofohara.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.libraryofohara.Models.Libro
import com.example.libraryofohara.R

class AdaptadorLibros(var libros: List<Libro>) :
    RecyclerView.Adapter<AdaptadorLibros.ViewHolderLibros>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLibros {
        //val minflater = LayoutInflater.from(parent.context)
        // toca crear la vista
        //val miView = minflater.inflate(R.layout.elemento_superheroe, parent, false)
        //return ViewHolderLibros(miView)
    }

    override fun getItemCount(): Int = libros.size


    override fun onBindViewHolder(holder: ViewHolderLibros, position: Int) {
        TODO("Not yet implemented")
    }

    class ViewHolderLibros(val vista: View) : ViewHolder(vista) {
        //val binding = ElementoLibroBinding.bind(vista)
        fun mostrar(libro: Libro){
            // codigo que haya en el elemento que se va a repetir
        }
    }
}