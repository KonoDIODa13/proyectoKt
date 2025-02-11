package com.example.libraryofohara.Providers

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.libraryofohara.Models.Autor
import com.example.libraryofohara.Models.Genero
import com.example.libraryofohara.Models.Libro
import com.example.libraryofohara.Models.Usuario
import java.time.LocalDate

class Provider {

    var brandom = Autor("Brandom Sanderson", 49)
    var george = Autor("George R. R. Martin", 69)
    var fantasia = Genero("Fantasia")
    var listaUsuarios = mutableListOf<Usuario>(
        Usuario("Jaime", "jaime.gonbra1789@gmail.com", "JaiGonBra9$9"),
    )

    @RequiresApi(Build.VERSION_CODES.O)
    var listaLibro = mutableListOf<Libro>(
        Libro("El Camino de los Reyes", brandom, fantasia, LocalDate.now()),
        Libro("Palabras Radiantes", brandom, fantasia, LocalDate.now()),
        Libro("Juramentada", brandom, fantasia, LocalDate.now()),
        Libro("Ritmo de la Guerra", brandom, fantasia, LocalDate.now()),
        Libro("Juego de Tronos", george, fantasia, LocalDate.now()),
        Libro("Choque de Reyes", george, fantasia, LocalDate.now()),
        Libro("Tormenta de Espadas", george, fantasia, LocalDate.now()),
    )
}