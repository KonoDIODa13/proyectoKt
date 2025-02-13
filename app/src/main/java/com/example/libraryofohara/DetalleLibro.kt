package com.example.libraryofohara


import android.os.Build
import android.os.Bundle
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

class DetalleLibro : AppCompatActivity() {
    lateinit var binding: ActivityDetalleLibroBinding
    lateinit var btnAnnadir: Button
    lateinit var btnEliminar: Button

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        iniciarComponentes()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun iniciarComponentes() {
        binding = ActivityDetalleLibroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val libro =
            Provider.listaLibro.first { book: Libro -> book.titulo.equals(intent.getStringExtra("titulo")) }

        var toolbar = binding.toolbarLibro
        toolbar.title = libro.titulo
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.ivLibroDetalle.cargarImagen(libro.portada)
        binding.tvAutorDetalle.text = libro.autor.nombre
        binding.tvGeneroDetalle.text = libro.genero.genero
        binding.tvFechaDetalle.text = libro.fechaPublicacion.toString()

        btnAnnadir = binding.btnAnnadir
        btnEliminar = binding.btnEliminar

        val usuario = PaginaUsuario.usuario!!
        var existe = false

        val listaLibrosUsuario = PaginaUsuario.librosUsuario
        listaLibrosUsuario.forEach { libroUsuario: LibroUsuario ->
            if (libroUsuario.usuario == usuario && libroUsuario.libro == libro) {
                existe = true
            }
        }
        mostrarBtn(existe)

        btnAnnadir.setOnClickListener {
            PaginaUsuario.librosUsuario.add(LibroUsuario(usuario, libro))
            Toast.makeText(this, "Libro insertado con exito.", Toast.LENGTH_SHORT)
            existe = true

        }

        btnEliminar.setOnClickListener {
            PaginaUsuario.librosUsuario.remove(LibroUsuario(usuario, libro))
            Toast.makeText(this, "Libro eliminado con exito.", Toast.LENGTH_SHORT)
            existe = false
        }
    }

    private fun mostrarBtn(existe: Boolean) {
        if (existe) {
            btnAnnadir.visibility = View.INVISIBLE
            btnEliminar.visibility = View.VISIBLE
        } else {
            btnAnnadir.visibility = View.VISIBLE
            btnEliminar.visibility = View.INVISIBLE
        }
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
