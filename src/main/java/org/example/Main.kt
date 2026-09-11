package org.example

import org.example.dto.Contenido
import org.example.dto.Pelicula
import org.example.dto.Serie
import  org.example.data.conectarServidorPlayFlix
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("=== SISTEMA DE GESTIÓN PLAYFLIX ===")
    conectarServidorPlayFlix()

    val catalogo: MutableList<Contenido> = mutableListOf()

    try {
        catalogo.add(Pelicula("Inception", "Ciencia Ficción", 148, 4.99, es4K = true))
        catalogo.add(Serie("Stranger Things", "Terror/Misterio", 50, 2.99, temporadas = 4))
        catalogo.add(Pelicula("Interstellar", "Ciencia Ficción", 169, 3.99, es4K = false))
        catalogo.add(Serie("The Crown", "Drama Histórico", 60, 3.50, temporadas = 5))
    } catch (e: IllegalArgumentException) {
        println("Error al agregar contenido al catálogo: ${e.message}")
    }

    println("--- CATÁLOGO COMPLETO ---")
    for (item in catalogo) {
        println(item.obtenerDetalles())
    }

    println("\n--- MÉTRICAS Y ANÁLISIS DE DATOS ---")

    val cienciaFiccion = catalogo.filter { it.genero.contains("Ciencia Ficción", ignoreCase = true) }
    println("\nContenido categorizado en 'Ciencia Ficción':")
    cienciaFiccion.forEach { println(" - ${it.titulo} (${it.duracionMinutos} min)") }

    val totalMinutos = catalogo.sumOf { it.duracionMinutos }
    println("Duración total del catálogo: $totalMinutos minutos")

    val contenidoLargo = catalogo.filter { it.duracionMinutos > 60 }
    println("\nContenidos de larga duración (> 60 min):")
    contenidoLargo.forEach { println(" - ${it.titulo} (${it.duracionMinutos} min)") }

    val costosTotales = catalogo.map { it.calcularCostoTotal() }
    val ingresoEstimado = costosTotales.sum()
    println("\nIngreso total estimado por reproducciones: $$ingresoEstimado")
}