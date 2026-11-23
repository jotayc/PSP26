# Ejercicio 7.2 · Productor y consumidor (esqueleto)

> Actividad **7.2** de `UD02_Actividades.html`.

Un hilo productor guarda 15 caracteres, uno a uno, en un buffer compartido con capacidad para 6. Un hilo consumidor los saca y los escribe. El productor solo puede poner cuando hay hueco, y el consumidor solo puede sacar cuando hay algo.

El productor duerme un tiempo al azar de 0 a 200 ms entre carácter y carácter, y el consumidor, de 0 a 400 ms. Después cambia los tiempos para que el consumidor sea el rápido.

## Qué tienes que completar

Las cuatro clases ya existen y compilan. Lo que falta está marcado con `TODO`:

| Clase | Qué falta |
|---|---|
| `Buffer` | Los métodos `poner()` y `sacar()`, y que el buffer se pueda usar desde los dos hilos a la vez. |
| `Productor` | El método `run()`. |
| `Consumidor` | El método `run()`. |
| `ProductorConsumidor` | Nada: solo cambiarás los tiempos máximos. |

Si lo ejecutas tal cual, solo sale la línea final: ni el productor ni el consumidor hacen nada todavía.

## Sabrás que está bien si

- Salen los 15 caracteres en el orden en que se produjeron, sin repetir ni perder ninguno.
- Los dos hilos terminan y el programa acaba solo.
- Con el consumidor rápido, el consumidor espera sin dar vueltas gastando procesador.

## Cómo ejecutarlo

**Desde NetBeans:** abre la carpeta como proyecto y pulsa *Run*. La clase principal ya viene puesta en el `pom.xml`.

**Desde la consola,** en la carpeta del proyecto:

```
mvn compile
java -cp target/classes ProductorConsumidor
```
