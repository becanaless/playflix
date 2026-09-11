package org.example.dto

class Serie(
    titulo: String,
    genero: String,
    duracionMinutos: Int,
    precioBase: Double,
    val temporadas: Int)
    : Contenido(titulo, genero, duracionMinutos, precioBase) {

    init {
        require(temporadas > 0) { "Una serie debe tener al menos 1 temporada." }
    }

    override fun calcularCostoTotal(): Double {
        return precioBase * temporadas
    }
    override fun obtenerDetalles(): String {
        return "[SERIE] ${super.obtenerDetalles()}" +
                "| Temporadas: $temporadas" +
                "| Costo Final: $$${calcularCostoTotal()}"
    }
}