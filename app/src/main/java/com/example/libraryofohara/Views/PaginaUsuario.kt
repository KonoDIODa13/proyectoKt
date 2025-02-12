package com.example.libraryofohara.Views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.libraryofohara.R
import com.example.libraryofohara.databinding.ActivityPaginaUsuarioBinding

class PaginaUsuario : AppCompatActivity() {
    lateinit var binding: ActivityPaginaUsuarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        iniciarComponentes()

    }

    private fun iniciarComponentes() {
        binding = ActivityPaginaUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}