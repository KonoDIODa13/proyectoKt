package com.example.libraryofohara.Providers

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.libraryofohara.Models.Autor
import com.example.libraryofohara.Models.Genero
import com.example.libraryofohara.Models.Libro
import com.example.libraryofohara.Models.Usuario
import java.time.LocalDate

class Provider {
    companion object {
        var brandom = Autor("Brandom Sanderson", 49)
        var george = Autor("George R. R. Martin", 69)
        var fantasia = Genero("Fantasia")
        var listaUsuarios = mutableListOf<Usuario>(
            Usuario("jaime", "jaime.gonbra1789@gmail.com", "123"),
        )

        @RequiresApi(Build.VERSION_CODES.O)
        var listaLibro = mutableListOf<Libro>(
            Libro(
                "El Camino de los Reyes",
                brandom,
                fantasia,
                LocalDate.now(),
                "https://cosmere.es/wp-content/uploads/2021/08/385-x-600-camino-1.jpg"
            ),
            Libro(
                "Palabras Radiantes",
                brandom,
                fantasia,
                LocalDate.now(),
                "https://cosmere.es/wp-content/uploads/2021/08/385-x-600-palabras.jpg"
            ),
            Libro(
                "Juramentada",
                brandom,
                fantasia,
                LocalDate.now(),
                "https://cosmere.es/wp-content/uploads/2021/08/385-x-600-Juramentada-1.png"
            ),
            Libro(
                "Ritmo de la Guerra",
                brandom,
                fantasia,
                LocalDate.now(),
                "https://cosmere.es/wp-content/uploads/2021/08/ritmo.jpg"
            ),
            Libro(
                "Juego de Tronos",
                george,
                fantasia,
                LocalDate.now(),
                "https://imagessl4.casadellibro.com/a/l/s7/34/9788466374934.webp"
            ),
            Libro(
                "Choque de Reyes",
                george,
                fantasia,
                LocalDate.now(),
                "https://imagessl1.casadellibro.com/a/l/s7/41/9788466374941.webp"
            ),
            Libro(
                "Tormenta de Espadas",
                george,
                fantasia,
                LocalDate.now(),
                "https://imagessl8.casadellibro.com/a/l/s7/58/9788466374958.webp"
            ),
        )
    }
}