package com.example.libraryofohara


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryofohara.Extensions.cargarImagen
import com.example.libraryofohara.Models.Libro
import com.example.libraryofohara.Models.LibroUsuario
import com.example.libraryofohara.Providers.Provider
import com.example.libraryofohara.databinding.ActivityDetalleLibroBinding
import com.example.libraryofohara.databinding.ActivityIniciarSesionBinding
import kotlin.math.log

class DetalleLibro : AppCompatActivity() {
    lateinit var binding: ActivityDetalleLibroBinding
    lateinit var btnAnnadir: Button
    lateinit var btnEliminar: Button
    var librosByUsuario = PaginaUsuario.librosUsuario
    var usuario = PaginaUsuario.usuario
    lateinit var libro: Libro

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        libro =
            Provider.listaLibro.first { book: Libro -> book.titulo.equals(intent.getStringExtra("titulo")) }
        Log.e("nombreLibro",libro.titulo)
        iniciarComponentes()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun iniciarComponentes() {
        binding = ActivityDetalleLibroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar = binding.toolbarLibro
        toolbar.title = libro.titulo
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.ivLibroDetalle.cargarImagen(libro.portada)
        binding.tvAutorDetalle.text = libro.autor.nombre
        binding.tvGeneroDetalle.text = libro.genero.genero
        binding.tvFechaDetalle.text = libro.fechaPublicacion.toString()

        btnAnnadir = binding.btnAnnadir
        btnEliminar = binding.btnEliminar
        mostrarBtn()


        btnAnnadir.setOnClickListener {
            if (!compruebaLibroExiste()) {
                librosByUsuario.add(LibroUsuario(usuario!!, libro))
                Toast.makeText(this, "Libro insertado con exito.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    this,
                    "No se puede añadir un libro que esta en la lista.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btnEliminar.setOnClickListener {
            if (compruebaLibroExiste()) {
                var libroAborrar: LibroUsuario? = null
                librosByUsuario.forEach { libroUsuario: LibroUsuario ->
                    if ((libroUsuario.usuario.nombre.equals(
                            usuario!!.nombre,
                            ignoreCase = false) && (libroUsuario.libro.titulo.equals(
                                libro.titulo,
                                ignoreCase = false)
                            )
                        )
                    ) {
                        libroAborrar = libroUsuario
                    }
                }
                librosByUsuario.remove(libroAborrar)
                Toast.makeText(this, "Libro eliminado con exito.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    this,
                    "No se puede eliminar de la lista si no está.",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }

    private fun mostrarBtn() {
        if (compruebaLibroExiste()) {
            btnAnnadir.visibility = View.INVISIBLE
            btnAnnadir.isEnabled = false
            btnEliminar.visibility = View.VISIBLE
            btnEliminar.isEnabled = true
        } else {
            btnAnnadir.visibility = View.VISIBLE
            btnAnnadir.isEnabled = true
            btnEliminar.visibility = View.INVISIBLE
            btnEliminar.isEnabled = false
        }
    }

    private fun compruebaLibroExiste(): Boolean {
        var exist = false
        for (librousuario in librosByUsuario) {
            if ((librousuario.usuario.nombre.equals(
                    usuario!!.nombre,
                    ignoreCase = true) && (librousuario.libro.titulo.equals(
                        libro.titulo,
                        ignoreCase = false
                    ))
                )
            ) {
                exist = true
            }
        }
        return exist
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return true
    }
}
