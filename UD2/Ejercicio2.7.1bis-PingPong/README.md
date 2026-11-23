# Ejercicio 7.1 bis · Ping-pong

> Actividad **7.1 bis** de `UD02_Actividades.html`.

Dos hilos se turnan para escribir `ping` y `pong`, diez veces cada uno, siempre alternados y empezando por ping. Comparten una `Mesa` con un `boolean` que dice a quién le toca: cada jugador espera su turno con `wait()`, escribe, pasa el turno y avisa con `notifyAll()`.

Es el mismo esquema que el `Buffer` de la actividad 7.2, con una sola condición en lugar de dos.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase
principal ya viene puesta en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes PingPong
```

El principal arranca primero el hilo del pong: aun así empieza el ping, porque el pong ve que no le toca y espera.
