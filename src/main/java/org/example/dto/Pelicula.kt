package org.example.dto

class Pelicula(
    titulo: String,
    genero: String,
    duracionMinutos: Int,
    precioBase: Double,
    val es4K: Boolean)
    : Contenido(titulo, genero, duracionMinutos, precioBase) {

    override fun calcularCostoTotal(): Double {
        //recargo del 20% si es en resolución 4K
        return if (es4K) precioBase * 1.20
        else precioBase
    }

    override fun obtenerDetalles(): String {
        val formato = if (es4K) "4K UHD"
        else "HD Standard"
        return "[PELÍCULA] ${super.obtenerDetalles()} | Formato: $formato | Costo Final: $$${calcularCostoTotal()}"
    }
}