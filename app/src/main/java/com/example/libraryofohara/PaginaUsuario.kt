package com.example.libraryofohara

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem


import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.example.libraryofohara.Models.LibroUsuario
import com.example.libraryofohara.Models.Usuario
import com.example.libraryofohara.Providers.Provider
import com.example.libraryofohara.databinding.ActivityPaginaUsuarioBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class PaginaUsuario : AppCompatActivity() {
    lateinit var binding: ActivityPaginaUsuarioBinding
    lateinit var bottomNavigation: BottomNavigationView
    lateinit var contenedorFragment: FragmentContainerView
    lateinit var toolbar: Toolbar

    companion object {
        var librosUsuario = mutableListOf<LibroUsuario>()
        var usuario: Usuario? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        iniciarComponentes()

    }

    private fun iniciarComponentes() {
        binding = ActivityPaginaUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usuario = Provider.listaUsuarios.first { user: Usuario ->
            user.nombre.equals(intent.getStringExtra("nombreUsuario"))
        }

        toolbar = findViewById(R.id.toolbar)
        toolbar.setTitle(usuario!!.nombre)
        toolbar.inflateMenu(R.menu.menu_opciones_usuario)

        contenedorFragment = binding.fragmentContainerView
        cambiarFragmento(PaginaUsuarioFragment())
        bottomNavigation = binding.bottomNavigation
        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.paguina_usuario -> {
                    cambiarFragmento(PaginaUsuarioFragment())
                }

                R.id.biblioteca -> {
                    cambiarFragmento(BibliotecaFragment())
                }
            }
            true
        }
    }

    private fun cambiarFragmento(fragmento: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(contenedorFragment.id, fragmento)
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            R.id.cerrarSesion -> {
                var intent = Intent(this, MainActivity::class.java)
                usuario = null
                startActivity(intent)
            }
        }
        return true
    }
}