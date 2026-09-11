package org.example.data

import kotlinx.coroutines.delay

suspend fun conectarServidorPlayFlix() {
    print("Conectando con los servidores de PlayFlix...")
    delay(2000)
    println(" ¡Conexión Exitosa!\n")
}
