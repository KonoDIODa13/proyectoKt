package com.example.libraryofohara

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryofohara.Views.IniciarSesion
import com.example.libraryofohara.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var btnInicioSesion:Button
    lateinit var btnRegister:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        iniciarComponentes()
    }

    private fun iniciarComponentes(){
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnInicioSesion= binding.btnLogin
        btnInicioSesion.setOnClickListener {
        var intent = Intent(this,IniciarSesion::class.java)
            /*var bundle= Bundle()
            bundle.putString("texto","esto es un texto")
            intent.putExtras(bundle)
            //bundle.getString("texto") asi para obtenerlo*/
            startActivity(intent)
        }
    }
}