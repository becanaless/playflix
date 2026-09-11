package org.example.dto

open class Contenido (val titulo: String, val genero: String, val duracionMinutos: Int, val precioBase: Double) {
    init {
        require(precioBase >= 0) { "El precio base debe ser mayor a 0" }
        require(duracionMinutos >= 0) { "La duracio debe ser mayor a 0" }
    }
    open fun obtenerDetalles(): String{
        return "Titulo: $titulo" +
                "| Genero: $genero" +
                "| Duracio: $duracionMinutos" +
                "| Precio: $precioBase"
    }
    open fun calcularCostoTotal(): Double {
        return precioBase
    }
}