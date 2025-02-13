package com.example.libraryofohara

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryofohara.Models.Usuario
import com.example.libraryofohara.Providers.Provider
import com.example.libraryofohara.databinding.ActivityRegistroBinding

class Registro : AppCompatActivity() {
    lateinit var binding: ActivityRegistroBinding
    lateinit var etNombre: EditText
    lateinit var etGmail: EditText
    lateinit var etContra: EditText
    lateinit var btnRegistro: Button
    var usuarios = Provider.listaUsuarios

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        iniciarComponentes()

    }

    private fun iniciarComponentes() {
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnRegistro = binding.btnRegistrarse
        etNombre = binding.etNombreRE
        etGmail = binding.etGmailRE
        etContra = binding.etContraRE
        btnRegistro.setOnClickListener {
            var resultado = compruebaTextos()
            if (resultado == 1) {
                Toast.makeText(this, "El nombre esta vacio", Toast.LENGTH_SHORT).show()
            }
            if (resultado == 2) {
                Toast.makeText(this, "La contraseña esta vacia", Toast.LENGTH_SHORT).show()
            }
            var usuario =
                Usuario(etNombre.text.toString(), etGmail.text.toString(), etContra.text.toString())
            var existe = registro(usuario)
            if (!existe) {
                usuarios.add(usuario)
                //Toast.makeText(this, "Usuario encontrado.", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, PaginaUsuario::class.java)
                //intent.putExtra("nombreUsuario", usuario.nombre)
                startActivity(intent)
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

    private fun registro(usuarioRegistro: Usuario): Boolean {
        return try {
            usuarios.first { usuario: Usuario ->
                usuario.nombre.equals(usuarioRegistro.nombre) &&
                        usuario.gmail.equals(usuarioRegistro.gmail) &&
                        usuario.contrasenna.equals(usuarioRegistro.contrasenna)
            }
            false
        } catch (nsee: NoSuchElementException) {
            true
        }
    }

}