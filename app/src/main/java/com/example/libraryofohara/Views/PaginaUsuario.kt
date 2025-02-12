package com.example.libraryofohara.Views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.example.libraryofohara.Models.Usuario
import com.example.libraryofohara.Providers.Provider
import com.example.libraryofohara.R
import com.example.libraryofohara.Views.Fragments.BibliotecaFragment
import com.example.libraryofohara.Views.Fragments.PaginaUsuarioFragment
import com.example.libraryofohara.databinding.ActivityPaginaUsuarioBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class PaginaUsuario : AppCompatActivity() {
    lateinit var binding: ActivityPaginaUsuarioBinding
    lateinit var bottomNavigation: BottomNavigationView
    lateinit var contenedorFragment: FragmentContainerView
    lateinit var usuario: Usuario
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        iniciarComponentes()

    }

    private fun iniciarComponentes() {
        usuario = Provider.listaUsuarios.first { usuario: Usuario ->
            usuario.nombre.equals(
                intent.getStringExtra("nombreUsuario")
            )
        }
        binding = ActivityPaginaUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contenedorFragment = binding.fragmentContainerView
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
            .replace(contenedorFragment.id, fragmento).commit()
    }
}