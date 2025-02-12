package com.example.libraryofohara.Views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryofohara.Models.Usuario
import com.example.libraryofohara.Providers.Provider
import com.example.libraryofohara.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var etNombre: EditText
    lateinit var etContra: EditText
    lateinit var btnIniciar: Button
    var usuarios = Provider.listaUsuarios

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        iniciarComponentes()

    }

    private fun iniciarComponentes() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnIniciar = binding.btnIniciarSesion
        etNombre = binding.etNombre
        etContra = binding.etContra
        btnIniciar.setOnClickListener {
            var resultado = compruebaTextos()
            if (resultado == 1) {
                Toast.makeText(this, "El nombre esta vacio", Toast.LENGTH_SHORT).show()
            }
            if (resultado == 2) {
                Toast.makeText(this, "La contraseña esta vacia", Toast.LENGTH_SHORT).show()
            }
            var usuario = login(etNombre.text.toString(), etContra.text.toString())
            if (usuario != null) {
                Toast.makeText(this, "Usuario encontrado.", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, PaginaUsuario::class.java)
                intent.putExtra("nombreUsuario", usuario.nombre)
            } else {
                Toast.makeText(this, "Usuario no encontrado.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun compruebaTextos(): Int {
        var comprobado = 0
        if (etNombre.text.isEmpty()) {
            comprobado = 1
        }
        if (etContra.text.isEmpty()) {
            comprobado = 2
        }
        return comprobado
    }

    private fun login(nombre: String, contra: String): Usuario? {
        return try {
            usuarios.first { usuario: Usuario ->
                usuario.nombre.equals(nombre) && usuario.contrasenna.equals(
                    contra
                )
            }
        } catch (nsee: NoSuchElementException) {
            null;
        }
    }
}