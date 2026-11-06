# Ejercicio 7.1 bis · Ping-pong (esqueleto)

> Actividad **7.1 bis** de `UD02_Actividades.html`.

Dos hilos se turnan para escribir: uno escribe `ping` y el otro `pong`, diez veces cada uno. Tiene que salir siempre ping, pong, ping, pong…, empezando por ping, aunque el hilo del pong arranque primero.

## Qué tienes que completar

Las tres clases ya existen y compilan. Lo que falta está marcado con `TODO`:

| Clase | Qué falta |
|---|---|
| `Mesa` | Los métodos `jugarPing()` y `jugarPong()`, y que la mesa se pueda usar desde los dos hilos a la vez. |
| `Jugador` | El método `run()`. |
| `PingPong` | Nada. |

Si lo ejecutas tal cual, solo sale la línea final: los jugadores todavía no hacen nada.

## Sabrás que está bien si

- Salen 20 líneas alternadas, empezando por ping, en todas las ejecuciones.
- Da igual qué hilo arranques primero.
- El programa termina solo.
- Ningún hilo da vueltas preguntando si le toca: el que no tiene el turno espera sin gastar procesador.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase principal ya viene puesta en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes PingPong
```
